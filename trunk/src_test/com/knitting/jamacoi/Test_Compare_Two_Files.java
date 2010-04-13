package com.knitting.jamacoi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class   Test_Compare_Two_Files {
	
static String  File_Separator       = "/";  //File.pathSeparator;

static String  File_Prefix          = "Test_Compare_Two_Files_content_10_";

static String  File_Expected        = File_Prefix + "expected";
static String  File_Matches         = File_Prefix + "actual_matches";
static String  File_Dif_Line_01     = File_Prefix + "actual_no_match_line_01";
static String  File_Dif_Line_02     = File_Prefix + "actual_no_match_line_02";
static String  File_Dif_Line_03     = File_Prefix + "actual_no_match_line_03";
static String  File_Line_Missing    = File_Prefix + "actual_less_one_line";
static String  File_Line_Extra      = File_Prefix + "actual_plus_one_line";

static String  File_Name            = "Test_400_not_significant.txt";
static String  File_Name_Missing    = "missing";

static String  Dir__Actual          = "expected";  // "actual";
static String  Dir__Expected        = "expected";
static String  Dir__Difference      = "difference";

       String  Dir__Actual_Full;
       String  Dir__Expected_Full;
       String  Dir__Difference_Full;
       
       String  Full_File_Actual;
       String  Full_File_Expected;
          
       String  Full_File_Difference;
       
       Compare_Two_Files c;

	@BeforeClass
	public static void setUpBeforeClass  () throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
           URL  actual          = this       . getClass()
                                             . getResource(Dir__Actual    );
           Dir__Actual_Full     = actual     . getPath(); 
           
           URL  expected        = this       . getClass()
                                             . getResource(Dir__Expected  );
           Dir__Expected_Full   = expected   . getPath();
           
           URL  difference      = this       . getClass()
                                             . getResource(Dir__Difference);
           Dir__Difference_Full = difference . getPath();
                
   		   Full_File_Actual         =  Dir__Actual_Full
                                    +  File_Separator
                                    +  File_Name;

   		   Full_File_Expected       =  Dir__Expected_Full
                                    +  File_Separator
                                    +  File_Name;

           Full_File_Difference     =  Dir__Difference_Full
                                    +  File_Separator
                                    +  File_Name;
           
           c                        =  new  Compare_Two_Files 
        		                    (  Full_File_Expected
                                    ,  Full_File_Actual
                                    ,  Full_File_Difference
                                    )  ;
           
	}
	private void show_Dir__Expected_Full(){
		
            System.out.println   ( "Dir__Expected_Full .... = >"
                                 +  Dir__Expected_Full
                                 + "<"
                                 ) ;
	}
	private void show_Dir__Actual_Full()  {
		
		    System.out.println   ( "Dir__Actual_Full ...... = >"
                                 +  Dir__Actual_Full
                                 + "<"
                                 ) ;
	}
	private void show_Dir__Difference_Full(){
        
		    System.out.println   ( "Dir__Difference_Full .. = >"
                                 +  Dir__Difference_Full
                                 + "<"
                                 ) ;
	}
	private void show_Full_File_Actual(){
		
            System.out.println   ( "Full_File_Actual ...... = >"
                                 +  Full_File_Actual
                                 + "<"
                                 ) ;
	}
	private void show_Full_File_Expected(){
		
            System.out.println   ( "Full_File_Expected .... = >"
                                 +  Full_File_Expected
                                 + "<"
                                 ) ;
	}
	private void show_Full_File_Difference(){
		
            System.out.println   ( "Full_File_Difference .. = >"
                                 +  Full_File_Difference
                                 + "<"
                                 ) ;
	}
	private void set_Full_File_Actual      (  String  Name  ){
	                 Full_File_Actual      =  Dir__Actual_Full
                                           +  File_Separator
                                           +  Name;
	}
	private void set_Full_File_Expected    (  String  Name  ){
	                 Full_File_Expected    =  Dir__Expected_Full
                                           +  File_Separator
                                           +  Name;
	}
    private void set_Full_File_Difference  (  String  Name  ){
	                 Full_File_Difference  =  Dir__Difference_Full
                                           +  File_Separator
                                           +  Name;
    }
	@After
	public void tearDown() throws Exception {
	}
    @Test
    public void test_Show_Info() {
		   show_Dir__Actual_Full    ();
   		   show_Dir__Expected_Full  ();
   		   show_Dir__Difference_Full();	
    }
	@Test
	public void test_02_files_match (){
		
	  	   set_Full_File_Expected   ( File_Expected );
		   set_Full_File_Actual     ( File_Matches  );
		   set_Full_File_Difference ( File_Matches  );
		
		  show_Full_File_Expected   ();
		  show_Full_File_Actual     ();
		  show_Full_File_Difference ();
		  
		  File e = new File    ( Full_File_Expected   );
		  File a = new File    ( Full_File_Actual     );
		  File d = new File    ( Full_File_Difference );
		  
		  assertTrue  ( e.exists() );
		  assertTrue  ( a.exists() );
		  assertFalse ( d.exists() );
		
//          c                         =  new  Compare_Two_Files 
//                                            (  Full_File_Expected
//                                            ,  Full_File_Actual
//                                            ,  Full_File_Difference
//                                            )  ;
//		  assertTrue ( c.exists_Expected() );
//		  assertTrue ( c.exists_Actual  () );
//		  assertTrue ( c.equal_Files    () );
	}

}