package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dmacc.config.HandBeanConfig;
import dmacc.model.Dealer;
import dmacc.model.Hand;
import dmacc.repo.IHandRepo;

@Controller
public class WebController {
	@Autowired
	IHandRepo repo;
	
	
	@GetMapping("/deal")
	public String deal(@RequestParam(name="choice") String choice, @RequestParam(name="savedHand", required = false) String savedHand, Model model) {
		if(choice.equals("deal")) {
			Dealer dealer = new Dealer();
			Hand hand = dealer.deal();
			model.addAttribute("hand", hand);
		}
		else if(choice.equals("save")) {
			ApplicationContext context = new AnnotationConfigApplicationContext(HandBeanConfig.class);
			Hand hand = context.getBean("hand", Hand.class);
			hand.setHand(savedHand);
			repo.save(hand);
			Hand saveStatus = new Hand();
			saveStatus.setHand("Saved!");
			model.addAttribute("hand", saveStatus);
		}
		return "showHand";
	}

}
