import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// test1は任意
// @RequestMapping("/test1")
public class Contoroller_json {
    // indexは任意
    @RequestMapping(value = "/index",
            method = {RequestMethod.POST})
    @ResponseBody
    public Set_json output1(
        @RequestBody Set_json set_json) {
            System.out.println(set_json.getFat());
            System.out.println(set_json.getSlim());
            System.out.println(set_json.getSleepy());
            System.out.println(set_json.getGood());
            System.out.println(set_json.getBad());

            return set_json;
        }
}