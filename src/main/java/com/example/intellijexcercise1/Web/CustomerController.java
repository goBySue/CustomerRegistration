package com.example.intellijexcercise1.Web;

import com.example.intellijexcercise1.Entities.Customer;
import com.example.intellijexcercise1.Repositories.Repo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@SessionAttributes({"id"})
@Controller
@AllArgsConstructor
public class CustomerController {

    @Autowired
    private Repo rr;
    List<Customer> xx;


    @GetMapping(path="/")
    public String InitialPage(Model model)
    {
        xx = rr.initialdata();

        model.addAttribute("customers", xx);
        model.addAttribute("customer", new Customer());

        return "Main";
    }


    @PostMapping(path = "/empInsert")
    public String AddCustomers(Model model, Customer customer, HttpSession session, ModelMap mm)
    {
        String em;
        String email = (String) session.getAttribute("id");

        if(email ==null){
            xx.add(customer);
            model.addAttribute("customers", xx);
            return "redirect:Main";
        }
        boolean flag= false;
        for (int x =0; x <xx.size(); ++x){
            em = xx.get(x).getCemail();
            if(email.equals(em))
            {
                xx.remove(x);
                xx.add(customer);
                flag = true;
                break;
            }
        }
        // both are needed
        mm.put("id", null);
        session.removeAttribute("id");
        return "redirect:Main";
    }

    @GetMapping(path = "/Main")
    public String IndexPage(Model model){
        model.addAttribute("customers", xx);
        model.addAttribute("customer", new Customer());

        return "/Main";
    }


   @GetMapping(path = "/editCustomer")
    public String editC(Model model, Customer customer, String id, HttpSession session, ModelMap mm)
    {
        // find the record in the list
        String em;
        mm.put("id", id);
        for(int x =0; x<xx.size(); ++x)
        {
            em= xx.get(x).getCemail();

            if(em.equals(id))
            {
                model.addAttribute("customer", xx.get(x));
                break;
            }
        }

        return "Main";
    }

 @GetMapping(path = "/deleteCustomer")
    public String delete(Model model, String id)
    {

        String em;

        for(int x =0; x<xx.size(); ++x)
        {
            em= xx.get(x).getCemail();

            if(em.equals(id))
            {
               xx.remove(x);
                break;
            }
        }

        return "redirect:Main";
    }
}


