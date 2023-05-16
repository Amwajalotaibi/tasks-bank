package com.example.tasktracker.Controller;

import com.example.tasktracker.ApiRespons.ApiRespons;
import com.example.tasktracker.takclass.Tak;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@RestController
@RequestMapping("api/v2/taks")
public class TaksController {
    ArrayList<Tak> taks=new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Tak> getTak(){
        return taks;
    }
    @PostMapping("/add")
    public ApiRespons addTak( @RequestBody Tak tak){
        taks.add(tak);
                return new ApiRespons("Taks Added ");
    }

    @PutMapping("/update/{index}")
    public ApiRespons updateTak(@PathVariable int index, @RequestBody Tak tak){
        taks.set(index,tak);
        return new ApiRespons("Taks updated!");
    }

    @DeleteMapping("/deleta/{index}")
    public ApiRespons deletaTak(@PathVariable int index){
        taks.remove(index);
                return new ApiRespons("Taks delete");
    }
@GetMapping("/title")
    public ApiRespons searchtak(String title ) {
    for (Tak tak:taks) {
        if (title.equals(tak.getTitle()));
            System.out.println("done");
        }
    return new ApiRespons ("Tasks Searched");
    }

@PutMapping("/change/{index}")
    public ApiRespons changeTak(@PathVariable int index){
        taks.get(index);
        Tak tak1=taks.get(index);
        tak1.getStatus("done");
        taks.set(index,tak1);
        return new ApiRespons ("Taks Updated! ");


}


}
