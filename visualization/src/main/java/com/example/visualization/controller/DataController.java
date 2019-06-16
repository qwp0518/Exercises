package com.example.visualization.controller;

import cn.com.essence.proto.assetcenter.overview.CashResponse;
import cn.com.essence.proto.assetcenter.overview.UserStkAssetRequest;
import com.example.visualization.pojo.RequestLabels;
import com.example.visualization.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class DataController {
    @Autowired
    private DataService dataService;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/insert")
    public String insertPage(RequestLabels requestLabels){
        return "form";
    }

    @RequestMapping("/validate")
    public String validate(@Valid RequestLabels requestLabels, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            return "form";
        }

//        UserStkAssetRequest userStkAssetRequest = dataService.showData(requestLabels);
        redirectAttributes.addAttribute("custNo",requestLabels.getCustNo());
        redirectAttributes.addAttribute("startDay",requestLabels.getStartDay());
        redirectAttributes.addAttribute("endDay",requestLabels.getEndDay());
        redirectAttributes.addAttribute("pageSize",requestLabels.getPageSize());
        redirectAttributes.addAttribute("pageNum",requestLabels.getPageNum());
        redirectAttributes.addAttribute("acctNo",requestLabels.getAcctNo());

        return "redirect:/show";
    }

    @RequestMapping("/show")
    @ResponseBody
    public CashResponse show(RequestLabels requestLabels){
        return dataService.showData(requestLabels);
    }

//    @RequestMapping("/test")
//    @ResponseBody
//    public RequestLabels test(RequestLabels labels){
//        return labels;
//    }
}
