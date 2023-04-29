package contact;

import com.google.gson.Gson;
import dto.ContactDto;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.testng.annotations.Test;

public class OkHttpADDNewContact {
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    Gson gson = new Gson();
    OkHttpClient clientn = new OkHttpClient();
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6Im5vYUBnbWFpbC5jb20ifQ.G_wfK7FRQLRTPu9bs2iDi2fcs69FHmW-0dTY4v8o5Eo";

    @Test
    public void addNewContactTest()
    {
        int index =(int)(System.currentTimeMillis()/1000)%3600;
        ContactDto contactDto=ContactDto.builder()
                .name("Maya")
                .lastName("Dow")
                .email("may"+index+"@gmail.com")
                .phone("3333"+index)
                .address("Haifa")
                .description("friend").build();
        RequestBody requestBody = RequestBody.create(gson.toJson(contactDto),JSON);
        Request request = new Request().Builder();
    }
}
