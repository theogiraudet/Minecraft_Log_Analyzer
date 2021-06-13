package fr.theogiraudet.log_analyzer.types;

import java.util.*;

/**
 * Représente un joueur
 */
public class Player {

    private static final Map<UUID, Player> players = new HashMap<>();

    /**
     * Récupère l'instance Player ayant le UUID et le nom spécifié.
     * Si un Player de même UUID mais de nom différent existe, ajoute le nom à la liste des noms du Player existant
     * @param uuid un UUID
     * @param name un nom
     * @return le Player ayant le UUID et le nom spécifié
     */
    public static Player get(UUID uuid, String name) {
        if(players.containsKey(uuid) && !players.get(uuid).names.contains(name))
                players.get(uuid).names.add(name);
        else if(!players.containsKey(uuid))
            players.put(uuid, new Player(uuid, name));

        return players.get(uuid);
    }


    private final UUID uuid;
    private final List<String> names = new LinkedList<>();

    /**
     * Crée un nouveau Player et l'ajoute à la liste des Players
     * @param uuid le UUID du joueur
     * @param name le nom du joueur
     */
    private Player(UUID uuid, String name) {
        this.uuid = uuid;
        names.add(name);
        players.put(uuid, this);
    }

    /**
     * @return le UUID du joueur
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * @return la liste non modifiable des noms du joueur
     */
    public List<String> getNames() {
        return Collections.unmodifiableList(names);
    }
}
