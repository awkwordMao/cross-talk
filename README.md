# cross-talk
程序入口：http://localhost:8880
关于thymeleaf重定向中文乱码问题：
 public String updateGreatNumber(@PathParam("crossId") Integer crossId, @PathParam("userName") String userName, RedirectAttributes attributes){
        crossService.updateCross(crossId);
//        model.addAttribute("userName", userName);
        attributes.addFlashAttribute("userName", userName);
        return "redirect:/cross/list/";
 使用RedirectAttributes类带值重定向url，若重定向后地址为controller，则需通过@ModelAttribute注解参数获取传来的值。
 public String crossList(Model model,@ModelAttribute(value = "userName") String userName){
        List<Cross> crossList = crossService.crossList();
        System.out.println("list:--" + userName);
        if(userName == null){
            userName = "";
        }
        System.out.println(userName);
        model.addAttribute("crossList", crossList);
        model.addAttribute("userName", userName);
        return "index";
    }
