package contact;

import com.google.gson.Gson;
import dto.AuthRequestDto;
import dto.AuthResponsDto;
import dto.ErrorDto;
import okhttp3.*;
import org.omg.Messaging.SyncScopeHelper;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class OkkHttpLoginTest {

   public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    @Test
    public void loginTest() throws IOException {
        AuthRequestDto requestDto = AuthRequestDto.builder().email("noa@gmail.com").password("Nnoa12345$")
                .build();
        Gson gson = new Gson();
        OkHttpClient clientn = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(gson.toJson(requestDto),JSON);

        Request request = new Request.Builder()
                .url("https://contacts-telran.herokuapp.com/api/login").post(requestBody).build();
        Response response = clientn.newCall(request).execute();

        if(response.isSuccessful()){
            String responseJson = response.body().string();
            AuthResponsDto responsDto = gson.fromJson(responseJson,AuthResponsDto.class);
            System.out.println(responsDto.getToken());
            System.out.println(response.code());
            Assert.assertTrue(response.isSuccessful());
        }else{
            System.out.println("Response code----->"+response.code());
            ErrorDto errorDto = gson.fromJson(response.body().string(),ErrorDto.class);
            System.out.println(errorDto.getCode()+"+++++++"+errorDto.getMessage()+errorDto.getDetails());
            Assert.assertFalse(response.isSuccessful());

        }

    }
}
//TOKEN:
//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5vYUBnbWFpbC5jb20ifQ.G_wfK7FRQLRTPu9bs2iDi2fcs69FHmW-0dTY4v8o5Eo