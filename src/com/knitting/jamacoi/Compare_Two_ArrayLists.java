package com.knitting.jamacoi;

import java.util.ArrayList;
import java.util.Iterator;

public  class   Compare_Two_ArrayLists {
        private                 ArrayList<String> expected;
        private                 ArrayList<String> actual;
       
private Compare_Two_ArrayLists(){}; // to prevent this use.
public  Compare_Two_ArrayLists( ArrayList<String> expected
		                      , ArrayList<String> actual
		                      ) {
	    this.expected         =                   expected;
	    this.actual           =                   actual;
}
public  boolean are_Equal(){
        ArrayList<String> difference_report = report_First_Difference();
        return          ( difference_report . size() == 0 );
}
public  ArrayList<String> report_First_Difference(){
        ArrayList<String> difference_report  = new ArrayList<String>();
return  difference_report;
}
public  int              get_Min (){
return  Math.min( expected . size() 
		        , actual   . size()
		        ) ;	
}
public  ArrayList<String> find_First_Difference(){
	    ArrayList<String> difference_entries = new ArrayList<String>();
	    int                      ix   = 0;
	    while   ( (              ix   < get_Min()      )
	    		  &&
	    		  ( expected.get(ix) == actual.get(ix) )
	    	    )  
	            {
	    	       System.out.println ( "ix = >"
	    	    		              +  ix
	    	    		              + "<"
	    	    		              );
	    	                   ++ix;
	            }
	    if      ( ix        < get_Min()       )
	            {
	    	      System.out.println( "About to execute: get_non_matching_lines");
	    	      get_non_matching_lines( ix, difference_entries );
	            }
	    else if ( get_Min() < expected.size() )
                {
	    	      System.out.println( "About to execute: get_unmatched_line"    );
                  get_unmatched_line    ( ix, difference_entries );
                }
	    else if ( get_Min() < actual  .size() )
                {
	    	      System.out.println( "About to execute: get_extra_line"        );
                  get_extra_line        ( ix, difference_entries );
                }
	    else    { // the ArrayLists are equal
	            }
	    
return  difference_entries;	
}

private void   get_non_matching_lines( int                ix
		                             , ArrayList<String>  difference_entries
		                             ) {
        difference_entries.add( get_row_expected(ix) );
        difference_entries.add( get_row_actual  (ix) );
}
private void   get_unmatched_line    ( int                ix
		                             , ArrayList<String>  difference_entries
		                             ) {
        difference_entries.add( get_row_expected(ix) );
        difference_entries.add( get_row_missing (ix) );	
}
private void   get_extra_line        ( int                ix
                                     , ArrayList<String>  difference_entries
                                     ) {
	    difference_entries.add( get_row_actual  (ix) );
	    difference_entries.add( get_row_extra   (ix) );
}
private String get_row_expected ( int ix ){
return         (  "row "
               +  ix
               +  ": expected =>"
               +     expected.get(ix)
               +  "<"
               )  ;
}
private String get_row_actual   ( int ix ){
return         (  "row "
               +  ix
               +  ": actual   =>"
               +     actual  .get(ix)
               +  "<"
               )  ;
}
private String get_row_missing  ( int ix ){
return         (  "row "
               +  ix
               +  ": actual   =>"
               +  "Error: there is no corresponding line here"
               +  "<"
               )  ;
}
private String get_row_extra    ( int ix ){
return         (  "row "
               +  ix
               +  ": actual   =>"
               +  "Error: this is an extra line that should not be here"
               +  "<"
               )  ;
}
public  void   print_ArrayList( ArrayList<String> list){
	    Iterator<String> iter = list.iterator();
	    
	    while ( iter.hasNext() )
	          {
	    	    System.out.println( iter.next() );
	          }
}

}