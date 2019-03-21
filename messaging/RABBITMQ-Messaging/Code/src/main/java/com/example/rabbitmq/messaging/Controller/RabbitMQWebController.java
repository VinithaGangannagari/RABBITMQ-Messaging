package com.example.rabbitmq.messaging.Controller;

import com.example.rabbitmq.messaging.model.Employee;
import com.example.rabbitmq.messaging.service.RabbitMQReciever;
import com.example.rabbitmq.messaging.service.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/sample-rabbitmq/")
public class RabbitMQWebController {

    @Autowired
    RabbitMQSender rabbitMQSender;


    @Autowired
    RabbitMQReciever rabbitMQReciever;

    @GetMapping(value = "/producer")
    public String producer(@RequestParam("empName") String empName,@RequestParam("empId") String empId) {

        Employee emp=new Employee();
        emp.setEmpId(empId);
        emp.setEmpName(empName);
        try {
            rabbitMQSender.send(emp);
        }
        catch (Exception e){}


        return "Message sent to the RabbitMQ JavaInUse Successfully";
    }


}
