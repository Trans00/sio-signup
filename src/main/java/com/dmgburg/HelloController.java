package com.dmgburg;

import com.dmgburg.dao.GamesRepository;
import com.dmgburg.domain.Game;
import com.dmgburg.domain.Player;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String onePage(ModelMap model) throws Exception {
        List<Game> games = new GamesRepository().getGames();
        model.addAttribute("message", "СиО сайт");
        model.addAttribute("games", games);
        return "hello";
    }

    @RequestMapping(method = RequestMethod.POST)
     public String submit(
        @RequestParam(value="name", required=false) String playerName,
        @RequestParam(value="comment", required=false) String playerComment,
        @RequestParam(value="where", required=false) int playerWhere,
        @RequestParam(value="gameName", required=false) String gameName) throws Exception {
        if(StringUtils.hasText(playerName)) {
            List<Game> games = new GamesRepository().getGames();
            for (Game game : games) {
                if (game.getName().equals(gameName)) {
                    if(playerWhere==1) {
                        game.addField(new Player(playerName, playerComment));
                    } else {
                        game.addHq(new Player(playerName, playerComment));
                    }
                }
            }
            new GamesRepository().saveGames(games);
        }
        return "redirect:";
    }

    @RequestMapping(path = "/addGame",method = RequestMethod.POST)
    public String submitGame(
        @RequestParam(value="name", required=false) String name,
        @RequestParam(value="date", required=false) String dateString) throws Exception {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
            if (StringUtils.hasText(name) && !date.equals(new Date())) {
                List<Game> games = new GamesRepository().getGames();
                games.add(new Game(name, date));
                new GamesRepository().saveGames(games);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:";
    }
}
