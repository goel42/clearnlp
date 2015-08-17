package edu.emory.clir.clearnlp.bin;

/**
 * @author jamesgung.
 */
public class PBPostProcessTestData {

    public static final String traceTree1 = "(TOP\n" +
            "  (S\n" +
            "    (S\n" +
            "      (NP-SBJ-2 (PRP It))\n" +
            "      (VP\n" +
            "        (VBZ has)\n" +
            "        (S\n" +
            "          (NP-SBJ (-NONE- *-2))\n" +
            "          (VP\n" +
            "            (TO to)\n" +
            "            (VP\n" +
            "              (VB be)\n" +
            "              (NP-PRD\n" +
            "                (NP (CD one))\n" +
            "                (PP\n" +
            "                  (IN of)\n" +
            "                  (NP\n" +
            "                    (NP (DT the) (JJS nicest) (NNS pubs))\n" +
            "                    (SBAR\n" +
            "                      (WHNP-1 (WDT that))\n" +
            "                      (S\n" +
            "                        (NP-SBJ (PRP i))\n" +
            "                        (VP\n" +
            "                          (VBP have)\n" +
            "                          (VP\n" +
            "                            (VBN been)\n" +
            "                            (PP-LOC-PRD\n" +
            "                              (IN into)\n" +
            "                              (NP (-NONE- *T*-1)))\n" +
            "                            (PP-TMP\n" +
            "                              (IN in)\n" +
            "                              (NP (DT a) (JJ long) (NN time)))))))))))))))\n" +
            "    (, ,)\n" +
            "    (S\n" +
            "      (S\n" +
            "        (NP-SBJ (DT the) (NN decor))\n" +
            "        (VP (VBZ is) (ADJP-PRD (JJ nice))))\n" +
            "      (CC and)\n" +
            "      (S\n" +
            "        (NP-SBJ (PRP it))\n" +
            "        (VP\n" +
            "          (VBZ has)\n" +
            "          (NP\n" +
            "            (NP (DT a) (ADJP (RB really) (JJ nice)) (NN garden))\n" +
            "            (CC and)\n" +
            "            (NP (DT a) (JJ lovely) (NN decking) (NN area))))))\n" +
            "    (. .)))\n";
    public static final String traceProp1Post = "reviews/110908.xml.parse 2 13 gold be be.01 ----- 7:1*10:1*14:1-ARG2 11:1-ARG1 13:0-rel 16:1-ARGM-TMP 7:1*10:1-LINK-SLC";
    public static final String traceProp1Pre = "reviews/110908.xml.parse 2 13 gold be be.01 ----- 11:1-ARG1 13:0-rel 14:1-ARG2 16:1-ARGM-TMP";
    public static final String traceTree2 = "(TOP\n" +
            "  (S\n" +
            "    (S\n" +
            "      (NP-SBJ (PRP I))\n" +
            "      (VP\n" +
            "        (MD can)\n" +
            "        (RB not)\n" +
            "        (VP\n" +
            "          (VB describe)\n" +
            "          (SBAR\n" +
            "            (WHADJP (WRB how) (JJ delicious))\n" +
            "            (FRAG\n" +
            "              (NP\n" +
            "                (DT the)\n" +
            "                (NML (NN mango) (CC and) (NN cheese))\n" +
            "                (NNS pastries)))))))\n" +
            "    (CC and)\n" +
            "    (S\n" +
            "      (NP-SBJ (DT the) (NNS omelets))\n" +
            "      (VP\n" +
            "        (VBP are)\n" +
            "        (SBAR-PRD\n" +
            "          (WHNP-1 (-NONE- 0))\n" +
            "          (S\n" +
            "            (NP-SBJ (-NONE- *PRO*))\n" +
            "            (VP\n" +
            "              (TO to)\n" +
            "              (VP (VB die) (PP-PRP (IN for) (NP (-NONE- *T*-1)))))))))\n" +
            "    (. .)))";
    public static final String traceProp2Post = "reviews/112579.xml.parse 8 18 gold die die.05 ----- 15:1*19:1-ARG1 16:1-ARG0 18:0-rel";
    public static final String traceProp2Pre = "reviews/112579.xml.parse 8 18 gold die die.05 ----- 16:1-ARG0 18:0-rel 19:1-ARG1";
    public static final String traceTree3 = "(TOP\n" +
            "  (S\n" +
            "    (NP-SBJ\n" +
            "      (NP (JJ Indoor) (NNS cats))\n" +
            "      (SBAR\n" +
            "        (WHNP-2 (WDT that))\n" +
            "        (S\n" +
            "          (NP-SBJ-1 (-NONE- *T*-2))\n" +
            "          (VP\n" +
            "            (VBP are)\n" +
            "            (ADVP (RB well))\n" +
            "            (VP (VBN cared) (PP-CLR (IN for) (NP (-NONE- *-1))))))))\n" +
            "    (ADVP (RB typically))\n" +
            "    (VP (VBP live) (NP-TMP (QP (CD 11) (SYM -) (CD 15)) (NNS years)))\n" +
            "    (. .)))";
    public static final String traceProp3Post = "answers/20111108105919AAHXkZF_ans.xml.parse 9 6 gold care care.03 ----- 0:1*2:1*3:1*7:1-ARG1 5:1-ARGM-MNR 6:0-rel 0:1*2:1-LINK-SLC";
    public static final String traceProp3Pre = "answers/20111108105919AAHXkZF_ans.xml.parse 9 6 gold care care.03 ----- 3:1-ARG0 5:1-ARGM-MNR 6:0-rel 7:1-ARG1";
    public static final String traceTree4 = "(TOP\n" +
            "  (FRAG\n" +
            "    (NP (CD 25))\n" +
            "    (: -)\n" +
            "    (NP\n" +
            "      (NP\n" +
            "        (NP (NN Percentage))\n" +
            "        (PP\n" +
            "          (IN of)\n" +
            "          (NP\n" +
            "            (JJ overall)\n" +
            "            (JJ worldwide)\n" +
            "            (NML (NN carbon) (NN dioxide))\n" +
            "            (NNS emissions))))\n" +
            "      (SBAR\n" +
            "        (WHNP-1 (-NONE- 0))\n" +
            "        (S\n" +
            "          (NP-SBJ (DT the) (NNP United) (NNP States))\n" +
            "          (VP\n" +
            "            (VBZ is)\n" +
            "            (ADJP-PRD\n" +
            "              (JJ responsible)\n" +
            "              (PP (IN for) (NP (-NONE- *T*-1))))))))\n" +
            "    (. .)))";

    public static final String traceProp4Post =
            "newsgroup/groups.google.com_alt.animals_0084bdc731bfc8d8_ENG_20040905_212000.xml.parse 10 14 gold responsible responsible.03 ----- 2:2*9:1*15:1-ARG1 10:1-ARG0 14:0-rel 2:2*9:1-LINK-SLC";
    public static final String traceProp4Pre = "newsgroup/groups.google.com_alt.animals_0084bdc731bfc8d8_ENG_20040905_212000.xml.parse 10 14 gold responsible responsible.03 ----- 10:1-ARG0 14:0-rel 15:1-ARG1";
    public static final String COME_ICH_TREE = "(TOP\n" +
            "  (S\n" +
            "    (NP-SBJ (PRP He))\n" +
            "    (VP\n" +
            "      (VBD added)\n" +
            "      (SBAR\n" +
            "        (SBAR\n" +
            "          (IN that)\n" +
            "          (S\n" +
            "            (`` \")\n" +
            "            (S\n" +
            "              (NP-SBJ (NNP America))\n" +
            "              (VP\n" +
            "                (VBZ does)\n" +
            "                (RB not)\n" +
            "                (VP\n" +
            "                  (VB understand)\n" +
            "                  (NP\n" +
            "                    (NP (NN anything))\n" +
            "                    (PP\n" +
            "                      (IN except)\n" +
            "                      (NP\n" +
            "                        (NP (DT the) (NN language))\n" +
            "                        (PP\n" +
            "                          (IN of)\n" +
            "                          (NP (NN force) (CC and) (NN retaliation)))))))))\n" +
            "            (, ,)\n" +
            "            (S\n" +
            "              (NP-SBJ-1 (PRP they))\n" +
            "              (VP\n" +
            "                (VBD were)\n" +
            "                (VP\n" +
            "                  (VBN kicked)\n" +
            "                  (NP (-NONE- *-1))\n" +
            "                  (PP-CLR (IN out) (PP (IN of) (NP (NNP Somalia))))\n" +
            "                  (PP (IN in) (NP (NN humiliation)))\n" +
            "                  (SBAR-TMP\n" +
            "                    (IN after)\n" +
            "                    (S\n" +
            "                      (NP-SBJ-2 (DT that) (NN soldier))\n" +
            "                      (VP\n" +
            "                        (VBD was)\n" +
            "                        (VP\n" +
            "                          (VBN dragged)\n" +
            "                          (NP (-NONE- *-2))\n" +
            "                          (PP-LOC (IN in) (NP (NNP Mogadishu)))\n" +
            "                          (SBAR-ADV\n" +
            "                            (IN for)\n" +
            "                            (S\n" +
            "                              (NP-SBJ (DT the) (JJ whole) (NN world))\n" +
            "                              (VP (TO to) (VP (VB see))))))))))))\n" +
            "            ('' \")))\n" +
            "        (, ,)\n" +
            "        (CC and)\n" +
            "        (SBAR\n" +
            "          (IN that)\n" +
            "          (S\n" +
            "            (`` \")\n" +
            "            (NP-SBJ (NP (DT the) (NN day)) (SBAR (-NONE- *ICH*-3)))\n" +
            "            (VP\n" +
            "              (MD will)\n" +
            "              (VP\n" +
            "                (VB come)\n" +
            "                (SBAR-3\n" +
            "                  (WHADVP-4 (WRB when))\n" +
            "                  (S\n" +
            "                    (NP-SBJ-5\n" +
            "                      (NP (DT the) (JJ dead) (NNS bodies))\n" +
            "                      (PP\n" +
            "                        (IN of)\n" +
            "                        (NP (NNPS Americans) (CC and) (NNPS Jews))))\n" +
            "                    (VP\n" +
            "                      (MD would)\n" +
            "                      (VP\n" +
            "                        (VB be)\n" +
            "                        (VP\n" +
            "                          (VP (VBN dragged) (NP (-NONE- *-5)))\n" +
            "                          (, ,)\n" +
            "                          (VP (VBN defiled) (NP (-NONE- *-5)))\n" +
            "                          (, ,)\n" +
            "                          (CC and)\n" +
            "                          (VP\n" +
            "                            (VBN stepped)\n" +
            "                            (PP\n" +
            "                              (IN on)\n" +
            "                              (NP (-NONE- *-5))\n" +
            "                              (PP-LOC\n" +
            "                                (IN in)\n" +
            "                                (NP\n" +
            "                                  (DT the)\n" +
            "                                  (NNP Arabian)\n" +
            "                                  (NNP peninsula)))))\n" +
            "                          (ADVP\n" +
            "                            (RB together)\n" +
            "                            (PP\n" +
            "                              (IN with)\n" +
            "                              (NP\n" +
            "                                (PRP$ their)\n" +
            "                                (NNS agents)\n" +
            "                                (CC and)\n" +
            "                                (NNS supporters))))\n" +
            "                          (ADVP-TMP (-NONE- *T*-4)))))))))\n" +
            "            ('' \")))))\n" +
            "    (. .)))";
    public static final String COME_ICH_PB_PRE =
            "weblog/blogspot.com_healingiraq_20040409053012_ENG_20040409_053012.xml.parse 24 49 gold come come.03 " +
                    "----- 45:2-ARG1 48:0-ARGM-MOD 49:0-rel";
    public static final String COME_ICH_PB_POST =
            "weblog/blogspot.com_healingiraq_20040409053012_ENG_20040409_053012.xml.parse 24 49 gold come come.03 " +
                    "----- 45:2;50:2-ARG1 48:0-ARGM-MOD 49:0-rel";

}
