package com.knitting.jamacoi;

import java.io.FileWriter;
import java.util.Formatter;

public   class       Report_YX {
private  Regression  r;
private  Sub_Matrix  sub_matrix;
private  FileWriter  Rpt_Detail;

public               Report_YX( Regression  r
		                      , Sub_Matrix  sub_matrix
		                      , FileWriter  Rpt_Detail
		                      )	
	     throws      java.io.IOException{

this.r            =  r;
this.sub_matrix   =  sub_matrix;
this.Rpt_Detail   =  Rpt_Detail;
}
public   void        write_details()
         throws      java.io.IOException
{
Rpt_Detail.write( fmt_line_01() );  
Rpt_Detail.write( fmt_line_02() );
Rpt_Detail.write( fmt_line_03() );
Rpt_Detail.write( fmt_line_04() );
Rpt_Detail.write( fmt_line_05() );
loop_thru_rows();
} 
protected  String  fmt_line_01(){
Formatter  line =  new Formatter();
	       line .  format("%n%n%s%n"
	                     ,"0) YX matrix contents ==========================="
	                     ); 
return     line .  toString();	
}
protected  String  fmt_line_02(){

Formatter  line  = new Formatter();
	       line  . format( "    %10s  %4s"
	                     , ""
	                     , ""
	                     );
for  (int   ic  = 0
	 ;      ic  < r.get_YX_max_cols()
	 ;    ++ic
	 )
	 {
	    line . format( "%15s"
	                 , sub_matrix.get_name_security(ic)
	                 );
	 }
	    line . format( "%n");	
return  line . toString();	
}
protected  String  fmt_line_03(){
	
Formatter line = new Formatter();
	      line . format( "    %10s  %4s"
	                   , ""
	                   , ""
	                   );

for  (int   ic  = 0
  	 ;      ic  < r.get_YX_max_cols()
	 ;    ++ic
	 )
	 {
	    line . format( "%15s"
	                 , sub_matrix.get_name_lag(ic)
	                 );
	 }
	    line . format( "%n");
return  line . toString();	  
}
protected  String  fmt_line_04(){
Formatter  line = new Formatter();

	       line . format( "    %10s  %4s"
	                    , "Row-ID"
	                    , "Time"
	                    );
	       line . format( "%15s"
	                    , "Y"
	                    );
for  (int   ic  = 0
	 ;      ic  < ( r.get_YX_max_cols() - 1 )
	 ;    ++ic
	 )
	 {
	    line . format( "%13s%02d"
	                 , "X"
	                 , (ic + 1)
	                 );
	 }
	    line . format( "%n");
return  line . toString();	
}
protected  String  fmt_line_05(){
Formatter  line = new Formatter();

  	       line . format( "    %10s  %4s"
	                    , "----------"
	                    , "----"
	                    );
for  (int   ic  = 0
	 ;      ic  < r.get_YX_max_cols()
	 ;    ++ic
	 )
	 {
	    line . format( "%15s"
	                 , "------------"
	                 );
	 }
	    line . format( "%n");
return  line . toString();	  
}
protected  void   loop_thru_rows()
           throws java.io.IOException
{	
for  (int  ir   = 0
	 ;     ir   < r.get_YX_max_rows()
	 ;   ++ir
	 )
	 {
	   Formatter line = new Formatter();

			     line . format( "    %s   %03d"
			                  , sub_matrix.get_row_id(ir)
			                  , ( ir + 1 )
			                  );
			     line . format("%s%n" 
			     		      , fmt_line_06_cells(ir)
			     		      );
			     Rpt_Detail.write( line.toString() );
			     
			     line = null;
	 }		     	
}
protected  String  fmt_line_06_cells(int  ir){
Formatter  line =  new Formatter();
for (int   ic   =  0
	;      ic   <  r.get_YX_max_cols()
	;    ++ic
	)
	{
	    line . format( "%15.5E"
			         , r.get_YX_cell(ir, ic)
			         );
	}
return  line . toString();	
}
}
