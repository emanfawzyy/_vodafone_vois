package RestAssuredAPI;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class RestRequestAPI {

    public static Properties prop;
    static String configpath=System.getProperty("user.dir")+"\\src\\test\\java\\com\\configuration\\config.properties";

    public RestRequestAPI() throws IOException {
        prop=new Properties();
        FileInputStream file=new FileInputStream(configpath);
        prop.load(file);
    }

    @Test(priority = 1)
    public void Get_all_users () throws IOException {
        RestAssured.baseURI= prop.getProperty("baseURI");
        RequestSpecification httprequest=RestAssured.given();
        Response response=httprequest.request(Method.GET);
        String responsebody=response.getBody().asString();
        System.out.println("response body is :"+responsebody);

        //assert on status code
        int statuscode=response.getStatusCode();
        System.out.println("status_code :"+statuscode);
        Assert.assertEquals(statuscode, 200);
        //mapper
        ObjectMapper mapper = new ObjectMapper();
        List<Object> list =mapper.readValue( responsebody,List.class);

        //assert number of user
        int number_of_user=  list.size();
        System.out.println("number of user: "+number_of_user);
        Assert.assertEquals(number_of_user,100);
    }

    @Test(priority = 2)
    public void Get_post_by_id()
    {
        String pathparam= prop.getProperty("userid");
        RestAssured.baseURI= prop.getProperty("baseURI");
        RequestSpecification httprequest=RestAssured.given();
        Response response=httprequest.request(Method.GET,pathparam);
        String responsebody=response.getBody().asString();
        System.out.println("reponse body is :"+responsebody);
        //assert status code
        int statuscode=response.getStatusCode();
        System.out.println("status code :"+statuscode);
        Assert.assertEquals(statuscode, 200);
        //assert user_id
        int userid=response.jsonPath().get("id");
        System.out.println("userid :"+userid);
        Assert.assertEquals(userid, 1);
    }

    @Test(priority=3)
    public void create_a_post()
    {
       // body
        JSONObject request=new JSONObject();
        request.put("title","foo");
        request.put("body","bar");
        request.put("userId",1);

        RestAssured.baseURI= prop.getProperty("baseURI");
        RequestSpecification httprequest=RestAssured.given();
        httprequest.header("Content-Type","application/json");
        httprequest.body(request);  //body of request
        Response response=httprequest.request(Method.POST);
        String responsebody=response.getBody().asString();
        System.out.println("reponse body is :"+responsebody);

        //assert on status code
        int statuscode=response.getStatusCode();
        System.out.println("status code :"+statuscode);
        Assert.assertEquals(statuscode, 201);

        //assert title
        String title_post=response.jsonPath().get("title");
        System.out.println("title_post :"+title_post);
        Assert.assertEquals(title_post, "new");

        //assert body
        String body_post=response.jsonPath().get("body");
        System.out.println("body _post :"+body_post);
        Assert.assertEquals(body_post, "bar");

        //assert userid
        int user_id=response.jsonPath().get("userId");
        System.out.println("user id :"+user_id);
        Assert.assertEquals(user_id, 1);
    }


}
