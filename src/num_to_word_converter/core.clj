(ns num-to-word-converter.core
  (:require [num-to-word-converter.num-to-word :refer
             [convert-number-to-words]])
  (:gen-class))

(defn -main
  [& args]
  (println (convert-number-to-words args) ))