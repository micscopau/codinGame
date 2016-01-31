package chuckNorris;

import java.util.*;

class ChuckNorrisEasy {
	
	    public static void main(String args[]) {
	    	
	    	System.err.println("Give me the message:");
	        
	    	Scanner in = new Scanner(System.in);
	        String MESSAGE = in.nextLine();
	      
	        System.err.println("Message: " + MESSAGE);
	        
	        char[] charMessage = MESSAGE.toCharArray();
	        
	        StringBuilder sbinMessage = new StringBuilder();
	       	        
	        for( char c : charMessage)
	        {  
	        	String temp = Integer.toBinaryString((int)c);
	        	
	        	if (temp.length() == 6)
	        	{
	        		temp = "0" + temp;
	        	}
	        	
	        	sbinMessage.append(temp); //no left padding of binary
	        }            
	       	    
	        int[] bitMessage = new int[sbinMessage.length()];
	        
	        for (int i =0 ; i < sbinMessage.length() ; i ++)
	        {
	            bitMessage[i] = Integer.parseInt(String.valueOf(sbinMessage.charAt(i)));
	            
	        }
	    	        
	        int prevI = -1;
	        int seriesCount = 0;
	        
	        StringBuilder sCN = new StringBuilder();
	        
	        for (int i = 0 ; i < bitMessage.length ; i++)
	        {
	            
	            int tempi = bitMessage[i];

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
	            
	            //end of message 
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
	    
	        System.err.println("sbinMessage: " + sbinMessage);
	        System.err.println("sCN: " + sCN);
	        
	        System.out.println(sCN);
	        
	        in.close();
	        
	        
	    }
	}