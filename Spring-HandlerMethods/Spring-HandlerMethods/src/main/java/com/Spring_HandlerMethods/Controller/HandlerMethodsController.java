package com.Spring_HandlerMethods.Controller;

import com.Spring_HandlerMethods.Bean.HandlerMethodsBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HandlerMethodsController {

    @GetMapping("/getvalues")
    public HandlerMethodsBean getValue(){
        HandlerMethodsBean bean = new HandlerMethodsBean(10, "aaa", 10, "INDIA");
        return bean;
    }

    @GetMapping("/getlist")
    public List<HandlerMethodsBean> getList(){
        List<HandlerMethodsBean> list = new ArrayList<HandlerMethodsBean>();
        list.add(new HandlerMethodsBean(10, "aaa", 10, "INDIA"));
        list.add(new HandlerMethodsBean(20,"bbb",20,"us"));
        list.add(new HandlerMethodsBean(30,"ccc",30,"UK"));
        list.add(new HandlerMethodsBean(40,"ddd",40,"CANADA"));
        list.add(new HandlerMethodsBean(50,"eee",50,"MALAYSIA"));
        return list;
    }

    // {id} --- URI Template
    // localhost:8080/employee/10/AAA/20/INDIA
    @GetMapping("/employee/{id}/{name}/{age}/{address}")
    public HandlerMethodsBean getEmployee(@PathVariable("id") int empId,
                                          @PathVariable("name") String empName,
                                          @PathVariable("age") int empAge,
                                          @PathVariable("address") String empAddress){

        return new HandlerMethodsBean(empId, empName, empAge, empAddress);
    }

    // localhost:8080/employee/request?id=101&name=aaa&age=25&address=US
    @GetMapping("/employee/request")
    public HandlerMethodsBean getRequestparam(@RequestParam int id,
                                              @RequestParam String name,
                                              @RequestParam int age,
                                              @RequestParam String address){

        return new HandlerMethodsBean(id, name, age, address);
    }

    @GetMapping("/employee/request/required")
    public HandlerMethodsBean getRequestParamRequired( @RequestParam int id,
                                                       @RequestParam String name,
                                                       @RequestParam int age,
                                                       @RequestParam (required = false) String address){

        return new HandlerMethodsBean(id, name, age, address);
    }

    @GetMapping("/employee/default")
    public HandlerMethodsBean getDefault(@RequestParam int id,
                                         @RequestParam String name,
                                         @RequestParam int age,
                                         @RequestParam (defaultValue = "INDIA") String address){

        return new HandlerMethodsBean(id, name, age, address);
    }


    @PostMapping("/employee/input")
    public HandlerMethodsBean employeeInput(@RequestBody HandlerMethodsBean bean){
        System.out.println("ID = "+bean.getId());
        System.out.println("Name = "+bean.getName());
        System.out.println("Age = "+bean.getAge());
        System.out.println("Address = "+bean.getAddress());
        return  bean;
    }

    @PutMapping("/employee/update/{id}")
    public HandlerMethodsBean editValue(@RequestBody HandlerMethodsBean bean,
                                        @PathVariable("id") int empId){
        System.out.println("ID = "+bean.getId());
        System.out.println("Name = "+bean.getName());
        System.out.println("Age = "+bean.getAge());
        System.out.println("Address = "+bean.getAddress());
        bean.setId(empId);
        return bean;
    }

    @DeleteMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable("id") int empId){
        return "DELETED SUCCESSFULLY!!! "+empId;
    }


// =============================== RESPONSE ENTITY ======================================

    @GetMapping("/getvalues/response")
    public ResponseEntity<HandlerMethodsBean> getValueresponse(){
        HandlerMethodsBean bean = new HandlerMethodsBean(10, "aaa", 10, "INDIA");
        return ResponseEntity.ok(bean);
    }

    @GetMapping("/getlist/response")
    public ResponseEntity<List<HandlerMethodsBean>> getListresponse(){
        List<HandlerMethodsBean> list = new ArrayList<HandlerMethodsBean>();
        list.add(new HandlerMethodsBean(10, "aaa", 10, "INDIA"));
        list.add(new HandlerMethodsBean(20,"bbb",20,"us"));
        list.add(new HandlerMethodsBean(30,"ccc",30,"UK"));
        list.add(new HandlerMethodsBean(40,"ddd",40,"CANADA"));
        list.add(new HandlerMethodsBean(50,"eee",50,"MALAYSIA"));
        return ResponseEntity.ok(list);
    }

    @GetMapping("/employee/response/{id}/{name}/{age}/{address}")
    public ResponseEntity<HandlerMethodsBean> getEmployeeresponse(@PathVariable("id") int empId,
                                          @PathVariable("name") String empName,
                                          @PathVariable("age") int empAge,
                                          @PathVariable("address") String empAddress){

        return ResponseEntity.ok(new HandlerMethodsBean(empId, empName, empAge, empAddress));
    }


    @GetMapping("/employee/request/required/response")
    public ResponseEntity<HandlerMethodsBean> getRequestParamResponse( @RequestParam int id,
                                                       @RequestParam String name,
                                                       @RequestParam int age,
                                                       @RequestParam (required = false) String address){

        return ResponseEntity.ok(new HandlerMethodsBean(id, name, age, address));
    }


    @GetMapping("/employee/default/response")
    public ResponseEntity<HandlerMethodsBean> getDefaultresponse(@RequestParam int id,
                                         @RequestParam String name,
                                         @RequestParam int age,
                                         @RequestParam (defaultValue = "INDIA") String address){

        return ResponseEntity.ok(new HandlerMethodsBean(id, name, age, address));
    }


    @PostMapping("/employee/input/response")
    public ResponseEntity<HandlerMethodsBean> employeeInputResponse(@RequestBody HandlerMethodsBean bean){
        System.out.println("ID = "+bean.getId());
        System.out.println("Name = "+bean.getName());
        System.out.println("Age = "+bean.getAge());
        System.out.println("Address = "+bean.getAddress());
        return new ResponseEntity<HandlerMethodsBean>(bean, HttpStatus.CREATED) ;
    }


    @PutMapping("/employee/update/response/{id}")
    public ResponseEntity<HandlerMethodsBean> editValueresponse(@RequestBody HandlerMethodsBean bean,
                                        @PathVariable("id") int empId){
        System.out.println("ID = "+bean.getId());
        System.out.println("Name = "+bean.getName());
        System.out.println("Age = "+bean.getAge());
        System.out.println("Address = "+bean.getAddress());
        bean.setId(empId);
        return ResponseEntity.ok(bean);
    }


    @DeleteMapping("/employee/delete/response/{id}")
    public ResponseEntity<String> deleteEmployeeresponse(@PathVariable("id") int empId){
        return ResponseEntity.ok("DELETED SUCCESSFULLY!!! "+empId);
    }
}
