package edu.emory.clir.clearnlp.bin;

import edu.emory.clir.clearnlp.constituent.CTReader;
import edu.emory.clir.clearnlp.constituent.CTTree;
import edu.emory.clir.clearnlp.lexicon.propbank.PBInstance;
import edu.emory.clir.clearnlp.lexicon.propbank.PBReader;
import edu.emory.clir.clearnlp.util.FileUtils;
import edu.emory.clir.clearnlp.util.IOUtils;
import edu.emory.clir.clearnlp.util.constant.StringConst;
import edu.emory.clir.clearnlp.util.lang.TLanguage;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jamesgung.
 */
public class PBPostProcessTest {

    public static final String PB_TEST_DIRECTORY = "src/test/resources/propbank-private/tests/pbpostprocess/";
    public static final String TREE_DIR = "src/test/resources/propbank-private/projects/";
    public static final String PRE = "PRE:";
    public static final String POST = "POST:";
    public static final String EXT = "test";

    public final PBPostProcess pbPostProcess = new PBPostProcess();

    public void testPBPostProcessSingle(String preString, String expectedOutput) {
        PBInstance pre = new PBInstance(preString);
        PBInstance expected = new PBInstance(expectedOutput);
        addTreeToInstance(pre);
        testPBPostProcessSingle(pre, expected);
    }

    public void testPBPostProcessSingle(PBInstance pre, PBInstance expected) {
        PBInstance post = pbPostProcess.postProcess(Collections.singletonList(pre), TLanguage.ENGLISH).get(0);
        assertEquals(expected.toString(), post.toString());
    }

    @Test
    public void runFileTests() throws Exception {

        for (String fileString : FileUtils.getFileList(PB_TEST_DIRECTORY, EXT, false)) {
            String pre = null, post = null;
            BufferedReader reader = IOUtils.createBufferedReader(new File(fileString));
            for (String line : readLines(reader)) {
                if (line.startsWith(PRE)) {
                    pre = line.replace(PRE, "").trim();
                } else if (line.startsWith(POST)) {
                    post = line.replace(POST, "").trim();
                }
            }
            assert reader != null;
            reader.close();
            testPBPostProcessSingle(pre, post);
        }

    }

    public List<String> readLines(BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }

    public void addTreeToInstance(PBInstance instance) {
        CTReader reader = new CTReader();
        reader.open(IOUtils.createFileInputStream(TREE_DIR + StringConst.FW_SLASH + instance.getTreePath()));
        CTTree tree = null;
        for (int treeID = -1; treeID < instance.getTreeID(); treeID++) {
            tree = reader.nextTree();
        }
        reader.close();
        new PBReader().addTreeToInstance(instance, tree, false);
    }

}