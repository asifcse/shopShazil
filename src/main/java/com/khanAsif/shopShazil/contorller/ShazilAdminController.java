
package com.khanAsif.shopShazil.contorller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

@Controller
@RequestMapping("/admin")
public class ShazilAdminController {

    @GetMapping("/index")
    public String shazilShopAdminIndex(Model model){
        return "adminIndex";
    }
}
