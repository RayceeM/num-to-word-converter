(ns num-to-word-converter.core
  (:require [num-to-word-converter.num-to-word :refer
             [convert-number-to-words]])
  (:gen-class))

(defn -main
  [& args]
  (doseq [num-string args]
    (try
      (println (convert-number-to-words (Integer/parseInt num-string)))
      (catch Exception e (println "not a valid number:" num-string)))))