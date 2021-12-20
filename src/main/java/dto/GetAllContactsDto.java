package dto;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class GetAllContactsDto {
    List<ContactDto> contacts;
}
