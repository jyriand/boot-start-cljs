(set-env!
 :source-paths #{"src/cljs"}
 :resource-paths #{"html"}
 :dependencies '[[adzerk/boot-cljs "1.7.228-1"]
                 [pandeiro/boot-http "0.7.3"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]])
