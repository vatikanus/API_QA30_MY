package contact;

import com.google.gson.Gson;
import dto.ContactDto;
import dto.GetAllContactsDto;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkHttpGetAllContacts {
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5vYUBnbWFpbC5jb20ifQ.G_wfK7FRQLRTPu9bs2iDi2fcs69FHmW-0dTY4v8o5Eo";
    OkHttpClient client = new OkHttpClient();
    Gson gson = new Gson();
    @Test
    public void getAllContact() throws IOException {
        Request request = new Request.Builder()
                .url("https://contacts-telran.herokuapp.com/api/contact")
                .addHeader("Authorization",token)
                .build();
        Response response = client.newCall(request).execute();
       Assert.assertTrue(response.isSuccessful());

       GetAllContactsDto contacts = gson.fromJson(response.body().string(),GetAllContactsDto.class);

       for (ContactDto contactDto :contacts.getContacts())
       {
           System.out.println(contactDto.getId());
           System.out.println(contactDto.getEmail());
           System.out.println("*******");
       }


    }
}
