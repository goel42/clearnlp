package edu.emory.clir.clearnlp.bin;

import edu.emory.clir.clearnlp.constituent.CTReader;
import edu.emory.clir.clearnlp.constituent.CTTree;
import edu.emory.clir.clearnlp.lexicon.propbank.PBInstance;
import edu.emory.clir.clearnlp.lexicon.propbank.PBReader;
import edu.emory.clir.clearnlp.util.constant.StringConst;
import edu.emory.clir.clearnlp.util.lang.TLanguage;
import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author jamesgung.
 */
public class PBPostProcessTest {

    public final CTReader treeReader = new CTReader();
    public final PBPostProcess pbPostProcess = new PBPostProcess();

    /**
     * CODE: failed-to-follow-trace
     * <p/>
     * DESC: post-processing program should follow the trace inside the PP-LOC-PRD under "been",
     * which is tagged by the annotators as ARG2, and add the WHNP-1 (10:1), and should then be able to make the
     * LINK-SLC between 7:1 and 10*1 (I presume this should happen automatically if we get it to follow the trace
     * correctly)
     * CURRENT: reviews/110908.xml.parse 2 13 gold be be.01 ----- 11:1-ARG1 13:0-rel 14:1-ARG2 16:1-ARGM-TMP
     * CORRECT: ./reviews/110908.xml.parse 2 13 hand be be.01 ----- 7:1*10:1-LINK-SLC 7:1*10:1*14:1-ARG2 11:1-ARG1 13:0-rel 16:1-ARGM-TMP
     */
    @Test @Ignore
    public void testFollowTrace1() {
        testPBPostProcessSingle(PBPostProcessTestData.traceProp1Pre, PBPostProcessTestData.traceTree1, PBPostProcessTestData.traceProp1Post);
    }

    /**
     * CODE: failed-to-follow-trace
     * <p/>
     * DESC: post-processing program should follow the trace inside the PP-PRP under "die",
     * which is tagged by the annotators as ARG1, and add the WHNP-1 (15:1).
     * <p/>
     * CURRENT: reviews/112579.xml.parse 8 18 gold die die.05 ----- 16:1-ARG0 18:0-rel 19:1-ARG1
     * CORRECT: reviews/112579.xml.parse 8 18 hand die die.05 ----- 15:1*19:1-ARG1 16:1-ARG0 18:0-rel
     */
    @Test @Ignore
    public void testFollowTrace2() {
        testPBPostProcessSingle(PBPostProcessTestData.traceProp2Pre, PBPostProcessTestData.traceTree2, PBPostProcessTestData.traceProp2Post);
    }

    /**
     * CODE: failed-to-follow-trace
     * <p/>
     * DESC: again, program should follow from the PP-CLR under "cared" (7:1) up to the NP-SBJ, follow that to the WHNP-2,
     * and get the LINK-SLC from there.  Again; this should hopefully all resove if we just get the preposition right.
     * <p/>
     * CURRENT: answers/20111108105919AAHXkZF_ans.xml.parse 9 6 gold care care.03 ----- 0:1*2:1*3:1-ARG0 5:1-ARGM-MNR 6:0-rel 7:1-ARG1 0:1*2:1-LINK-SLC
     * CORRECT: answers/20111108105919AAHXkZF_ans.xml.parse 9 6 hand care care.03 ----- 0:1*2:1-LINK-SLC 0:1*2:1*3:1*7:1-ARG1 5:1-ARGM-MNR 6:0-rel
     */
    @Test @Ignore
    public void testFollowTrace3() {
        testPBPostProcessSingle(PBPostProcessTestData.traceProp3Pre, PBPostProcessTestData.traceTree3, PBPostProcessTestData.traceProp3Post);
    }

    /**
     * CODE: failed-to-follow-trace
     * <p/>
     * DESC: post-processing program should follow the trace inside the PP under "responsible",
     * which is tagged by the annotators as ARG1, and add the WHNP-1 (9:1), and should then be
     * able to make the LINK-SLC between 2:2 and 9*1 (I presume this should happen automatically if we get it to follow the trace correctly)
     * <p/>
     * CURRENT: newsgroup/groups.google.com_alt.animals_0084bdc731bfc8d8_ENG_20040905_212000.xml.parse 10 14 gold responsible responsible.03 ----- 10:1-ARG0 14:0-rel 15:1-ARG1
     * CORRECT: newsgroup/groups.google.com_alt.animals_0084bdc731bfc8d8_ENG_20040905_212000.xml.parse 10 14 hand responsible responsible.03 ----- 2:2*9:1-LINK-SLC 2:2*9:1*15:1-ARG1 10:1-ARG0 14:0-rel
     */
    @Test @Ignore
    public void testFollowTrace4() {
        testPBPostProcessSingle(PBPostProcessTestData.traceProp4Pre, PBPostProcessTestData.traceTree4, PBPostProcessTestData.traceProp4Post);
    }

    /**
     * CODE: ICH/RNR argument doubling
     * <p/>
     * DESC: I believe that the post-processing program should follow ICH and RNR links within terms, and add an ";"
     * link to them. Sometimes these other terms were annotated with arguments; ideally we'd spit out readable error
     * logs and replace those other arguments with the ";" link.
     * <p/>
     * CORRECT: weblog/blogspot.com_healingiraq_20040409053012_ENG_20040409_053012.xml.parse 24 49 hand come come.03 ----- 45:2;50:2-ARG1 48:0-ARGM-MOD 49:0-rel
     */
    @Test @Ignore
    public void testFollowIchRnr() {
        testPBPostProcessSingle(PBPostProcessTestData.COME_ICH_PB_PRE, PBPostProcessTestData.COME_ICH_TREE, PBPostProcessTestData.COME_ICH_PB_POST);
    }

    public void testPBPostProcessSingle(String pbString, String treeString, String expectedOutput) {
        PBReader reader = new PBReader(getStringInputStream(pbString));
        List<PBInstance> instanceList = reader.getSortedInstanceList();
        CTTree tree = readTree(treeString);
        System.out.println(tree.toString(true, true, StringConst.NEW_LINE));
        System.out.println(tree.toForms());
        reader.addTreeToInstance(instanceList.get(0), tree, false);
        PBInstance post = pbPostProcess.postProcess(instanceList, TLanguage.ENGLISH).get(0);
        assertEquals(expectedOutput, post.toString());
    }

    public CTTree readTree(String treeString) {
        treeReader.open(getStringInputStream(treeString));
        CTTree ctTree = treeReader.nextTree();
        treeReader.close();
        return ctTree;
    }

    public InputStream getStringInputStream(String string) {
        return new ByteArrayInputStream(string.getBytes(StandardCharsets.UTF_8));
    }

}