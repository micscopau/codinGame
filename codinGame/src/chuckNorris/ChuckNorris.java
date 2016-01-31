package chuckNorris;

import java.util.*;
import java.io.*;
import java.math.*;
import java.nio.charset.StandardCharsets;

class ChuckNorrisEasy {
	
	    public static void main(String args[]) {
	    	
	    	System.err.println("Give me the message:");
	        
	    	Scanner in = new Scanner(System.in);
	        String MESSAGE = in.nextLine();
	      
	        System.err.println("Message: " + MESSAGE);
	        
	        char[] charMessage = MESSAGE.toCharArray();
	        
	        StringBuilder sbinMessage = new StringBuilder();
	    
	        //byte[] bitMessage = MESSAGE.getBytes(StandardCharsets.UTF_8);
	        //byte[] bitMessage = MESSAGE.getBytes(StandardCharsets.US_ASCII);
	        //byte[] bitMessage = MESSAGE.getBytes();        
	        
	        for( char c : charMessage)
	        {  
	        //    System.err.println("C:" + c);
	            sbinMessage.append(Integer.toBinaryString((int)c)); //no left padding of binary
	            
	        }            
	        
	     //   System.err.println("sBinMessage: " + sbinMessage);
	        
	        
////	        String[] bitMessage = sbinMessage.toString().split("");
	        
	        //works but not as efficient
	        //byte[] bitMessage = String.valueOf(sbinMessage).getBytes();
	        
	        
	        
	        
	        
	        /*
	        byte[] bitMessage = new byte[charMessage.length];
	        for (int i = 0 ; i < charMessage.length ; i++)
	        {
	            bitMessage[i] = (byte)(charMessage[i] & 0x007F);
	        }
	        */
	/*

	        for (byte b : bitMessage)
	        {
	            int val = b;
	             
	            // the error is here. We are making an 8bit binary number when it only needs to be 7 long. at least for "c".
	            // this extra is adding a 0 in front of everything.
	            for (int i = 0 ; i < 8 ; i++)
	            {
	                sbinMessage.append((val & 128) == 0 ? 0:1);
	                val <<= 1;
	            }
	           // binMessage.append(' ');
	        }
	*/

	/*
	    for(String c : bitMessage)
	        {
	            System.err.println(c);
	        }
	    */

	    
	        int[] bitMessage = new int[sbinMessage.length()];
	        
	        for (int i =0 ; i < sbinMessage.length() ; i ++)
	        {
	            bitMessage[i] = Integer.parseInt(String.valueOf(sbinMessage.charAt(i)));
	            
	        }
	    

	/*
	        System.err.println("bitMessage: " );
	        for (int i = 0 ; i < bitMessage.length; i++)
	        {
	                System.err.println( bitMessage[i]);
	        }

	*/
	        
//	        System.err.println("sBinMessage: " + sbinMessage);

	      //  int[] ibinMessage = new int[sbinMessage.length()];
	        int count = 0;
	/*
	        for (char ch: sbinMessage.toCharArray())
	        {
	            ibinMessage[count] = (int) ch;
	            count ++;         
	            
	        }
	*/
	       
	   
	        //byte[] bitMessage = new byte[sbinMessage.length];
	        
	        /*
	        for (int i =0 ; i < sbinMessage.length() ; i ++)
	        {
	            bitMessage[i] = Integer.parseInt(String.valueOf(sbinMessage.charAt(i)));
	            
	        }
	        */

	        
	        int prevI = -1;
	        int seriesCount = 0;
	        
	        StringBuilder sCN = new StringBuilder();
	        
	        //for (int i : bitMessage)
	        for (int i = 0 ; i < bitMessage.length ; i++)
	        {
	            
	            int tempi = bitMessage[i];
	            //System.err.println("tempi: " + tempi);
	            
	            
	            //start
	            if (prevI < 0)
	            {
	                
	                prevI = tempi;
	                seriesCount++;
	            }
	            
	            //matching middle
	            else if (prevI == tempi ) 
	            {
	                seriesCount++;
	            }
	            
	            //unmatching middle
	            else 
	            {
	                    
	                if (prevI == 0)
	                {
	                    sCN.append( "00" + " ");
	                }
	                else
	                {
	                    sCN.append( "0" + " ");
	                }
	            
	                for ( int j = 0 ; j < seriesCount ; j++)
	                {
	                    sCN.append(0);
	        
	                }
	                
	                sCN.append (" ");
	                
	                prevI = tempi;
	                seriesCount = 1;
	            }
	            
	           // System.err.println("i: " + i);
	            //System.err.println("bitMessage.length: " + bitMessage.length);
	            
	            if( i == bitMessage.length-1)
	            {
	                 if (tempi == 0)
	                {
	                    sCN.append( "00" + " ");
	                }
	                else
	                {
	                    sCN.append( "0" + " ");
	                }
	            
	                for ( int j = 0 ; j < seriesCount ; j++)
	                {
	                    sCN.append(0);
	                }
	                
	            }
	                
	        }
	    

	   //     System.err.println("MESSAGE: " + MESSAGE);
	        System.err.println("sbinMessage: " + sbinMessage);
	        System.err.println("sCN: " + sCN);
	        
	        System.out.println(sCN);
	        
	        in.close();
	        
	        
	    }
	}



