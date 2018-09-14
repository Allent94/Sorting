import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @author Allen Tran
 * @version July 01 2018
 *
 */
public class Main
{

    public static void main(String[] args){
    	
    	LinkedList<Integer> list = new LinkedList<Integer>();
    	LinkedList<Integer> list2 = new LinkedList<Integer>();
    	LinkedList<Integer> list3 = new LinkedList<Integer>();
    	
    	Sorting<Integer> sort = new Sorting<Integer>();
    	
    	try{
    		
    		File file = new File("random100.txt");
    		File file2 = new File("random1000.txt");
    		File file3 = new File("random10000.txt");
    		Scanner in = new Scanner(file);
    		Scanner in2 = new Scanner(file2);
    		Scanner in3 = new Scanner(file3);
    		
    		while(in.hasNextInt())	{

    			list.add(in.nextInt());

    		}
    		in.close();
    		
    		while(in2.hasNextInt()){
    			
    			list2.add(in2.nextInt());
    		}
    		in2.close();
    		
    		while(in3.hasNextInt()){
    			
    			list3.add(in3.nextInt());
    		}
    		in3.close();

    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}


    	BufferedWriter bw = null;
    	FileWriter fw = null;
    	
    	File output = new File("output.txt");
    	
    	try{
    		
    	
    	if (!output.exists()){
    		output.createNewFile();
    	}
    	
    	fw = new FileWriter(output.getAbsolutePath(), true);
    	bw = new BufferedWriter(fw);
    
    	
    	bw.append(sort.resultShellSort(list));
    	bw.append(sort.resultShellSort(list2));
    	bw.append(sort.resultShellSort(list3));
    	
    	bw.append(sort.resultBubbleSort(list));
    	bw.append(sort.resultBubbleSort(list2));
    	bw.append(sort.resultBubbleSort(list3));

    }catch(IOException e){
    	e.printStackTrace();
    }finally{
    	
    	try{
    	
    	if(bw != null){
    		bw.close();
    	}
    	if(fw != null){
    		fw.close();
    	}
    	}catch(IOException ex){
        	ex.printStackTrace();
    }
    }
    	
    }
}