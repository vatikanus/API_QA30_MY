package dto;


import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder

public class AuthRequestDto {
    String email;
    String password;
}
