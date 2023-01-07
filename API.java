
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class API {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String testCases_File_path = args[0];
		String chromeDriver_path = args[1];
		String result_Detail_path = testCases_File_path.substring(0, testCases_File_path.length()-4) + "_Detail_Result.txt";
		String result_Csv_path = testCases_File_path.substring(0, testCases_File_path.length()-4) + "_Result.csv";
		
		File csvFile = new File(testCases_File_path);
		PrintWriter detail_File = new PrintWriter(new FileWriter(result_Detail_path));
		if (csvFile.isFile()) 
		{
			csvReader = new BufferedReader(new FileReader(testCases_File_path));
			for(iter=0; iter<testCaseFrom;iter++)
			{
				csvReader.readLine();
			}
			while ((row = csvReader.readLine()) != null && iter <= testCaseTo && iter > 0) 
			{
				// Reading input parameters from file for each row
			    String[] rowData = row.split(",");
			    testCase_ID = rowData[0];
			    testCase_Des = rowData[1];
			    id_List = rowData[2];
			    
			    detail_File.println("----- TestCase ID: "+ testCase_ID + " ----- "+ testCase_Des +" -----");
			    detail_File.println();
			    System.out.println("----- TestCase ID: "+ testCase_ID + " ----- "+ testCase_Des +" -----");
			    System.out.println();	
			}
			    
		String APIKey = "c97bdca12960b5317dd95700ce0e8e9d";
		String APIToken = "ATTA2603a197847fbf0c42c9e9a5eb76901b74f3c4cc14610c1d88a26512bf4d183e9A7A120E";
		
		createCard();
		updateCard();
		deleteCard();
	}	
	
	public static void createCard()
	{
	
		HttpResponse<JsonNode> response = Unirest.post("https://api.trello.com/1/cards")
				  .header("Accept", "application/json")
				  .queryString("idList", idList)
				  .queryString("key", APIKey)
				  .queryString("token", APIToken)
				  .asJson();
		
		httpsURLConnection.getResponseMessage();
		
		// Response Code Verification
		if(httpsURLConnection.getResponseCode() == 200)
		{
			actual_Resp = "Pass";
			bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
			stringBuilder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
			  stringBuilder.append(line);
			}
			
			bufferedReader.close();
			
			// Response
			System.out.println("Card creation Information Response:" + stringBuilder.toString());
			detail_File.println("Card creation Response:" + stringBuilder.toString());
			
		}
		else
		{
			// If not valid Response Code
			actual_Resp = "Fail";
			bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));
			stringBuilder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
			  stringBuilder.append(line);
			}
			
			bufferedReader.close();
			
			System.out.println("Card creation Response:" + stringBuilder.toString());
			detail_File.println("Card creation Response:" + stringBuilder.toString());
			
		}
		// Disconnecting
		httpsURLConnection.disconnect();
		System.out.println();
		detail_File.println();
	}
	
	public static void updateCard()
	{
		
		HttpResponse<JsonNode> response = Unirest.put("https://api.trello.com/1/cards/" + idList)
				  .header("Accept", "application/json")
				  .queryString("key", APIKey)
				  .queryString("token", APIToken)
				  .asJson();
		
		httpsURLConnection.getResponseMessage();
		
		// Response Code Verification
		if(httpsURLConnection.getResponseCode() == 200)
		{
			actual_Resp = "Pass";
			bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
			stringBuilder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
			  stringBuilder.append(line);
			}
			
			bufferedReader.close();
			
			// Response
			System.out.println("Card updation Information Response:" + stringBuilder.toString());
			detail_File.println("Card updation Response:" + stringBuilder.toString());
			
		}
		else
		{
			// If not valid Response Code
			actual_Resp = "Fail";
			bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));
			stringBuilder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
			  stringBuilder.append(line);
			}
			
			bufferedReader.close();
			
			System.out.println("Card updation Response:" + stringBuilder.toString());
			detail_File.println("Card updation Response:" + stringBuilder.toString());
			
		}
		// Disconnecting
		httpsURLConnection.disconnect();
		System.out.println();
		detail_File.println();
	}
	
	public static void deleteCard()
	{
		
		HttpResponse<String> response = Unirest.delete("https://api.trello.com/1/cards/" + idList)
				  .queryString("key", APIKey)
				  .queryString("token", APIToken)
				  .asString();
		
		httpsURLConnection.getResponseMessage();
		
		// Response Code Verification
		if(httpsURLConnection.getResponseCode() == 200)
		{
			actual_Resp = "Pass";
			bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getInputStream()));
			stringBuilder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
			  stringBuilder.append(line);
			}
			
			bufferedReader.close();
			
			// Response
			System.out.println("Card Deletion Information Response:" + stringBuilder.toString());
			detail_File.println("Card Deletion Response:" + stringBuilder.toString());
			
		}
		else
		{
			// If not valid Response Code
			actual_Resp = "Fail";
			bufferedReader = new BufferedReader(new InputStreamReader(httpsURLConnection.getErrorStream()));
			stringBuilder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
			  stringBuilder.append(line);
			}
			
			bufferedReader.close();
			
			System.out.println("Card Deletion Response:" + stringBuilder.toString());
			detail_File.println("Card Deletion Response:" + stringBuilder.toString());
			
		}
		// Disconnecting
		httpsURLConnection.disconnect();
		System.out.println();
		detail_File.println();
	}
	
	
}
