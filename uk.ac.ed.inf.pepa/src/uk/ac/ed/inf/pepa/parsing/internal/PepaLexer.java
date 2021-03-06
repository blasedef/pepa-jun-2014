/*******************************************************************************
 * Copyright (c) 2006, 2009 University of Edinburgh.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the BSD Licence, which
 * accompanies this feature and can be downloaded from
 * http://groups.inf.ed.ac.uk/pepa/update/licence.txt
 *******************************************************************************/
/* The following code was generated by JFlex 1.4.1 on 12/3/07 4:02 PM */

/* 20070222 Brand new implementation of the PEPA scanner.
 *
 * Author: Mirco Tribastone -mtribast
 */

package uk.ac.ed.inf.pepa.parsing.internal;

import java.io.Reader;
import java.io.InputStreamReader;
import uk.ac.ed.inf.pepa.parsing.ILocationInfo;
import java_cup.runtime.Symbol;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.1
 * on 12/3/07 4:02 PM from the specification file
 * <tt>/Users/ajduguid/Documents/University/Eclipse-workspace/uk.ac.ed.inf.pepa/src/jflex/PepaLocation.jflex</tt>
 */
public class PepaLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\44\1\3\1\2\1\0\1\3\1\1\16\44\4\0\1\3\1\0"+
    "\1\42\1\36\1\44\1\41\2\0\1\22\1\23\1\5\1\35\1\11"+
    "\1\34\1\10\1\4\1\6\11\7\1\26\1\24\1\30\1\25\1\31"+
    "\2\0\23\45\1\21\6\45\1\37\1\0\1\40\1\0\1\44\1\0"+
    "\1\13\4\43\1\17\2\43\1\15\4\43\1\16\5\43\1\12\1\14"+
    "\3\43\1\20\1\43\1\32\1\27\1\33\1\0\41\44\2\0\4\44"+
    "\4\0\1\43\2\0\1\44\7\0\1\43\4\0\1\43\5\0\27\45"+
    "\1\0\7\45\30\43\1\0\10\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\2\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\2\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\2\45\1\43\1\45\1\43\1\45\3\43\2\45"+
    "\1\43\1\45\1\43\2\45\1\43\3\45\2\43\4\45\1\43\2\45"+
    "\1\43\3\45\3\43\2\45\1\43\2\45\1\43\1\45\1\43\1\45"+
    "\1\43\2\45\1\43\1\45\2\43\1\45\1\43\2\45\1\43\3\45"+
    "\1\43\1\45\1\43\2\45\2\43\1\44\1\45\3\43\4\44\1\45"+
    "\1\44\1\43\1\45\1\44\1\43\1\45\1\44\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\2\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\2\43\1\45\1\44\1\43\1\45\1\43\3\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\4\43\31\0\140\43\22\44"+
    "\4\0\14\44\16\0\5\44\11\0\1\44\21\0\130\44\5\0\23\44"+
    "\12\0\1\44\13\0\1\45\1\0\3\45\1\0\1\45\1\0\2\45"+
    "\1\43\21\45\1\0\11\45\43\43\1\0\2\43\3\45\3\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\5\43\1\45\1\43\1\0\1\45\1\43\2\45\1\43"+
    "\4\0\60\45\60\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\0\4\44\3\0"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\2\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\0\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\2\0\1\45\1\43"+
    "\6\0\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\41\0\46\45\2\0"+
    "\1\44\7\0\47\43\11\0\21\44\1\0\27\44\1\0\3\44\1\0"+
    "\1\44\1\0\2\44\1\0\1\44\13\0\33\44\5\0\3\44\15\0"+
    "\4\44\14\0\6\44\13\0\32\44\5\0\31\44\7\0\12\44\4\0"+
    "\146\44\1\0\11\44\1\0\12\44\1\0\23\44\2\0\1\44\17\0"+
    "\74\44\2\0\3\44\60\0\62\44\u014f\0\71\44\2\0\22\44\2\0"+
    "\5\44\3\0\14\44\2\0\12\44\21\0\3\44\1\0\10\44\2\0"+
    "\2\44\2\0\26\44\1\0\7\44\1\0\1\44\3\0\4\44\2\0"+
    "\11\44\2\0\2\44\2\0\3\44\11\0\1\44\4\0\2\44\1\0"+
    "\5\44\2\0\16\44\15\0\3\44\1\0\6\44\4\0\2\44\2\0"+
    "\26\44\1\0\7\44\1\0\2\44\1\0\2\44\1\0\2\44\2\0"+
    "\1\44\1\0\5\44\4\0\2\44\2\0\3\44\13\0\4\44\1\0"+
    "\1\44\7\0\17\44\14\0\3\44\1\0\11\44\1\0\3\44\1\0"+
    "\26\44\1\0\7\44\1\0\2\44\1\0\5\44\2\0\12\44\1\0"+
    "\3\44\1\0\3\44\2\0\1\44\17\0\4\44\2\0\12\44\1\0"+
    "\1\44\17\0\3\44\1\0\10\44\2\0\2\44\2\0\26\44\1\0"+
    "\7\44\1\0\2\44\1\0\5\44\2\0\10\44\3\0\2\44\2\0"+
    "\3\44\10\0\2\44\4\0\2\44\1\0\3\44\4\0\12\44\1\0"+
    "\1\44\20\0\2\44\1\0\6\44\3\0\3\44\1\0\4\44\3\0"+
    "\2\44\1\0\1\44\1\0\2\44\3\0\2\44\3\0\3\44\3\0"+
    "\10\44\1\0\3\44\4\0\5\44\3\0\3\44\1\0\4\44\11\0"+
    "\1\44\17\0\11\44\11\0\1\44\7\0\3\44\1\0\10\44\1\0"+
    "\3\44\1\0\27\44\1\0\12\44\1\0\5\44\4\0\7\44\1\0"+
    "\3\44\1\0\4\44\7\0\2\44\11\0\2\44\4\0\12\44\22\0"+
    "\2\44\1\0\10\44\1\0\3\44\1\0\27\44\1\0\12\44\1\0"+
    "\5\44\2\0\11\44\1\0\3\44\1\0\4\44\7\0\2\44\7\0"+
    "\1\44\1\0\2\44\4\0\12\44\22\0\2\44\1\0\10\44\1\0"+
    "\3\44\1\0\27\44\1\0\20\44\4\0\6\44\2\0\3\44\1\0"+
    "\4\44\11\0\1\44\10\0\2\44\4\0\12\44\22\0\2\44\1\0"+
    "\22\44\3\0\30\44\1\0\11\44\1\0\1\44\2\0\7\44\3\0"+
    "\1\44\4\0\6\44\1\0\1\44\1\0\10\44\22\0\2\44\15\0"+
    "\72\44\4\0\20\44\1\0\12\44\47\0\2\44\1\0\1\44\2\0"+
    "\2\44\1\0\1\44\2\0\1\44\6\0\4\44\1\0\7\44\1\0"+
    "\3\44\1\0\1\44\1\0\1\44\2\0\2\44\1\0\15\44\1\0"+
    "\3\44\2\0\5\44\1\0\1\44\1\0\6\44\2\0\12\44\2\0"+
    "\2\44\42\0\1\44\27\0\2\44\6\0\12\44\13\0\1\44\1\0"+
    "\1\44\1\0\1\44\4\0\12\44\1\0\42\44\6\0\24\44\1\0"+
    "\6\44\4\0\10\44\1\0\44\44\11\0\1\44\71\0\42\44\1\0"+
    "\5\44\1\0\2\44\1\0\7\44\3\0\4\44\6\0\12\44\6\0"+
    "\12\44\106\0\46\45\12\0\51\44\7\0\132\44\5\0\104\44\5\0"+
    "\122\44\6\0\7\44\1\0\77\44\1\0\1\44\1\0\4\44\2\0"+
    "\7\44\1\0\1\44\1\0\4\44\2\0\47\44\1\0\1\44\1\0"+
    "\4\44\2\0\37\44\1\0\1\44\1\0\4\44\2\0\7\44\1\0"+
    "\1\44\1\0\4\44\2\0\7\44\1\0\7\44\1\0\27\44\1\0"+
    "\37\44\1\0\1\44\1\0\4\44\2\0\7\44\1\0\47\44\1\0"+
    "\23\44\16\0\11\44\56\0\125\44\14\0\u026c\44\2\0\10\44\12\0"+
    "\32\44\5\0\113\44\3\0\3\44\17\0\15\44\1\0\7\44\13\0"+
    "\25\44\13\0\24\44\14\0\15\44\1\0\3\44\1\0\2\44\14\0"+
    "\124\44\3\0\1\44\3\0\3\44\2\0\12\44\41\0\3\44\2\0"+
    "\12\44\6\0\130\44\10\0\52\44\126\0\35\44\3\0\14\44\4\0"+
    "\14\44\12\0\50\44\2\0\5\44\u038b\0\54\43\66\44\12\43\224\0"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43"+
    "\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\7\43"+
    "\4\0\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45\1\43\1\45"+
    "\1\43\6\0\10\43\10\45\6\43\2\0\6\45\2\0\10\43\10\45"+
    "\10\43\10\45\6\43\2\0\6\45\2\0\10\43\1\0\1\45\1\0"+
    "\1\45\1\0\1\45\1\0\1\45\10\43\10\45\16\43\2\0\10\43"+
    "\10\44\10\43\10\44\10\43\10\44\5\43\1\0\2\43\4\45\1\44"+
    "\1\0\1\43\3\0\3\43\1\0\2\43\4\45\1\44\3\0\4\43"+
    "\2\0\2\43\4\45\4\0\10\43\5\45\5\0\3\43\1\0\2\43"+
    "\4\45\1\44\17\0\4\44\32\0\5\44\20\0\2\44\23\0\1\44"+
    "\13\0\4\44\6\0\6\44\1\0\1\43\15\0\1\43\40\0\22\44"+
    "\36\0\15\44\4\0\1\44\3\0\6\44\27\0\1\45\4\0\1\45"+
    "\2\0\1\43\3\45\2\43\3\45\1\43\1\0\1\45\3\0\5\45"+
    "\6\0\1\45\1\0\1\45\1\0\1\45\1\0\4\45\1\0\1\43"+
    "\2\45\1\0\1\45\1\43\4\44\1\43\3\0\1\43\2\45\5\0"+
    "\1\45\4\43\26\0\44\44\u0e81\0\3\44\31\0\17\44\1\0\5\44"+
    "\2\0\5\44\4\0\126\44\2\0\2\44\2\0\3\44\1\0\137\44"+
    "\5\0\50\44\4\0\136\44\21\0\30\44\70\0\20\44\u0200\0\u19b6\44"+
    "\112\0\u51a6\44\132\0\u048d\44\u0773\0\u2ba4\44\u215c\0\u012e\44\2\0\73\44"+
    "\225\0\7\43\14\0\5\43\5\0\14\44\1\0\15\44\1\0\5\44"+
    "\1\0\1\44\1\0\2\44\1\0\2\44\1\0\154\44\41\0\u016b\44"+
    "\22\0\100\44\2\0\66\44\50\0\15\44\3\0\20\44\20\0\4\44"+
    "\17\0\2\44\30\0\3\44\31\0\1\44\6\0\5\44\1\0\207\44"+
    "\2\0\1\44\4\0\1\44\13\0\12\44\7\0\32\45\4\0\1\44"+
    "\1\0\32\43\12\0\132\44\3\0\6\44\2\0\6\44\2\0\6\44"+
    "\2\0\3\44\3\0\2\44\3\0\2\44\22\0\3\44\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\5\1\6\1\7"+
    "\1\10\3\11\1\12\1\13\1\14\1\15\1\16\2\1"+
    "\1\17\1\20\1\21\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\1\1\31\2\0\1\5\2\11\1\32"+
    "\1\33\1\0\1\34\2\0\1\35\1\11\1\0\1\2"+
    "\1\11\1\12";

  private static int [] zzUnpackAction() {
    int [] result = new int[49];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\46\0\114\0\46\0\162\0\46\0\230\0\276"+
    "\0\46\0\46\0\344\0\u010a\0\u0130\0\u0156\0\46\0\46"+
    "\0\46\0\46\0\u017c\0\u01a2\0\46\0\46\0\46\0\46"+
    "\0\46\0\46\0\46\0\46\0\46\0\46\0\u01c8\0\u0156"+
    "\0\u01ee\0\u0214\0\u023a\0\u0260\0\u0286\0\46\0\46\0\u01c8"+
    "\0\46\0\u02ac\0\u02d2\0\u010a\0\u02f8\0\u031e\0\u02ac\0\u0344"+
    "\0\u010a";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[49];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\2\4\1\5\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\2\14\1\15\3\14\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\14"+
    "\1\2\1\40\50\0\1\4\47\0\1\41\1\42\46\0"+
    "\1\7\1\10\1\43\43\0\2\10\1\43\43\0\2\14"+
    "\2\0\1\14\1\44\6\14\21\0\3\14\6\0\2\14"+
    "\2\0\10\14\21\0\3\14\6\0\2\14\2\0\4\14"+
    "\1\45\3\14\21\0\3\14\6\0\2\40\2\0\10\40"+
    "\21\0\3\40\25\0\1\46\47\0\1\47\16\0\42\50"+
    "\1\51\3\50\1\41\1\3\1\4\43\41\5\52\1\53"+
    "\40\52\6\0\2\43\44\0\2\14\2\0\2\14\1\54"+
    "\5\14\21\0\3\14\6\0\2\14\2\0\5\14\1\55"+
    "\2\14\21\0\3\14\5\52\1\56\44\52\1\57\1\56"+
    "\40\52\6\0\2\14\2\0\1\60\7\14\21\0\3\14"+
    "\4\52\1\4\1\56\40\52\6\0\2\14\2\0\6\14"+
    "\1\61\1\14\21\0\3\14";

  private static int [] zzUnpackTrans() {
    int [] result = new int[874];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\1\1\1\11\1\1\1\11\2\1\2\11"+
    "\4\1\4\11\2\1\12\11\2\1\2\0\3\1\2\11"+
    "\1\0\1\11\2\0\2\1\1\0\3\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[49];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the textposition at the last state to be included in yytext */
  private int zzPushbackPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
	  int getCurrentLineNumber(){
	    return yyline;
	  }
	
	  int getCurrentColumn(){
	    return yycolumn;
	  }
	  
	  int getCurrentChar() {
	  	return yychar;
	  }
	  
	  public PepaLexer(Reader reader, NewPepaSymbolFactory sf) {
	  	this(reader);
	  	symbolFactory = sf;
	  	
	  }
	  public PepaLexer(NewPepaSymbolFactory sf){
	        this(new InputStreamReader(System.in));
	        symbolFactory = sf;
	  }
  
	private NewPepaSymbolFactory symbolFactory;
    
    public Symbol symbol(String name, int code) {
        return symbolFactory.newSymbol(name, code,
        	createLeftLocation(), createRightLocation());
    }
    public Symbol symbol(String name, int code, Object lexem){
    
        return symbolFactory.newSymbol(name, code, 
        	createLeftLocation(), createRightLocation(), lexem);
    }
    
    private ILocationInfo createLeftLocation() {
    	return new LocationInfo(yyline+1, yycolumn+1, yychar);
    }
    private ILocationInfo createRightLocation() {
    	return new LocationInfo(yyline+1, yycolumn+1, yychar+yylength());
    }



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public PepaLexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public PepaLexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 3098) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzPushbackPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead < 0) {
      return true;
    }
    else {
      zzEndRead+= numRead;
      return false;
    }
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = zzPushbackPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = zzLexicalState;


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 6: 
          { return symbol("PASSIVE_MULTIPLIER", PepaToken.PASSIVE_MULTIPLIER, 
				Integer.valueOf(yytext()));
          }
        case 30: break;
        case 12: 
          { return symbol("RPARENT", PepaToken.RPAREN);
          }
        case 31: break;
        case 29: 
          { return symbol("TAU", PepaToken.TAU, yytext());
          }
        case 32: break;
        case 27: 
          { return symbol("PAR", PepaToken.PAR);
          }
        case 33: break;
        case 8: 
          { return symbol("COMMA", PepaToken.COMMA);
          }
        case 34: break;
        case 26: 
          { return symbol("RATE_EQUALS", PepaToken.RATE_EQUALS);
          }
        case 35: break;
        case 20: 
          { return symbol("SUM", PepaToken.SUM);
          }
        case 36: break;
        case 24: 
          { return symbol("PERC", PepaToken.PERC);
          }
        case 37: break;
        case 14: 
          { return symbol("EQUALS", PepaToken.EQUALS);
          }
        case 38: break;
        case 16: 
          { return symbol("RCOOP", PepaToken.RCOOP);
          }
        case 39: break;
        case 11: 
          { return symbol("LPAREN", PepaToken.LPAREN);
          }
        case 40: break;
        case 7: 
          { return symbol("DOT", PepaToken.DOT);
          }
        case 41: break;
        case 5: 
          { return symbol("DOUBLE_NUMBER", PepaToken.DOUBLE_NUMBER,Double.valueOf(yytext()));
          }
        case 42: break;
        case 1: 
          { return symbol("ERROR", PepaToken.error,"Illegal character: <" + yytext() + ">");
          }
        case 43: break;
        case 17: 
          { return symbol("LSET", PepaToken.LSET);
          }
        case 44: break;
        case 25: 
          { return symbol("PROCESS_STRN", PepaToken.PROCESS_STRN,yytext());
          }
        case 45: break;
        case 13: 
          { return symbol("SEMI", PepaToken.SEMI);
          }
        case 46: break;
        case 15: 
          { return symbol("LCOOP", PepaToken.LCOOP);
          }
        case 47: break;
        case 19: 
          { return symbol("MINUS", PepaToken.MINUS);
          }
        case 48: break;
        case 28: 
          { return symbol("QUOTED_STRN", PepaToken.QUOTED_STRN, yytext());
          }
        case 49: break;
        case 18: 
          { return symbol("RSET", PepaToken.RSET);
          }
        case 50: break;
        case 22: 
          { return symbol("LSQUARE", PepaToken.LSQUARE);
          }
        case 51: break;
        case 3: 
          { return symbol("DIVIDE", PepaToken.DIVIDE);
          }
        case 52: break;
        case 9: 
          { return symbol("ACTIVITY_STRN", PepaToken.ACTIVITY_STRN,yytext());
          }
        case 53: break;
        case 4: 
          { return symbol("MULT", PepaToken.MULT);
          }
        case 54: break;
        case 23: 
          { return symbol("RSQUARE", PepaToken.RSQUARE);
          }
        case 55: break;
        case 21: 
          { return symbol("HASH", PepaToken.HASH);
          }
        case 56: break;
        case 10: 
          { return symbol("TOP", PepaToken.TOP);
          }
        case 57: break;
        case 2: 
          { /* ignore */
          }
        case 58: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {     return symbolFactory.newSymbol("EOF",PepaToken.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
