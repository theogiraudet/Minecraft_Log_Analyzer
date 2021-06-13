package fr.theogiraudet.log_analyzer.datas;

/**
 * Représente une donnée à récupérer du fichier de log
 */
public interface Data {

    /**
     * @param line une ligne du fichier de log
     * @return true si la ligne correspond à la donnée courante, false sinon
     */
    boolean isParsable(String line);

    /**
     * Parse la ligne pour en extraire les données. <br/>
     * La ligne doit être parsable (voir {@link #isParsable isParsable})
     * @param line une ligne du fichier de log
     * @throws IllegalArgumentException si la ligne n'est pas parsable par cette donnée
     */
    void parse(String line);

}
