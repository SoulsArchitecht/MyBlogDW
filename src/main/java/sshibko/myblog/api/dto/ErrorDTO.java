package sshibko.myblog.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import sshibko.myblog.api.response.ResultResponse;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO extends ResultResponse {

    private Map<String, String> errors;

    public ErrorDTO(boolean result, String message) {
        super(result);
        this.errors = new HashMap<>();
        this.errors.put("message", message);
    }

    public ErrorDTO(boolean result, String type, String message) {
        super(result);
        this.errors = new HashMap<>();
        this.errors.put(type, message);
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}
