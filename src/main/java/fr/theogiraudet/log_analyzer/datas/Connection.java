package fr.theogiraudet.log_analyzer.datas;


import fr.theogiraudet.log_analyzer.RegexUtils;
import fr.theogiraudet.log_analyzer.types.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * Donnée représentant le nombre de connexion
 */
public class Connection implements Data {

    private final Pattern pattern = Pattern.compile(String.format(".+ UUID of player (%s?) is (%s)", RegexUtils.NICKNAME, RegexUtils.UUID));
    private final Map<Player, Integer> data = new HashMap<>();

    @Override
    public boolean isParsable(String line) {
        return pattern.matcher(line).matches();
    }

    @Override
    public void parse(String line) {
        if(!isParsable(line))
            throw new IllegalArgumentException("'line' is not parsable by this data.");

        final var matcher = pattern.matcher(line);
        if(matcher.find()) {
            final var player = Player.get(UUID.fromString(matcher.group(2)), matcher.group(1));
            data.put(player, data.getOrDefault(player, 0) + 1);
        }
    }
}
