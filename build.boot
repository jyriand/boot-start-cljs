(set-env!
 :source-paths #{"src/cljs"}
 :resource-paths #{"html"}
 :dependencies '[[org.clojure/clojure "1.8.0"]         ;; add CLJ
                 [org.clojure/clojurescript "1.8.40"]
                 [adzerk/boot-cljs "1.7.228-1"]
                 [pandeiro/boot-http "0.7.3"]
                 [adzerk/boot-reload "0.4.6"]
                 [adzerk/boot-cljs-repl "0.3.0"]
                 [com.cemerick/piggieback "0.2.1"  :scope "test"]
                 [weasel                  "0.7.0"  :scope "test"]
                 [org.clojure/tools.nrepl "0.2.12" :scope "test"]
                 [crisptrutski/boot-cljs-test "0.2.2-SNAPSHOT"]
                 [adzerk/boot-test            "1.0.6"]
                 [reagent "0.6.0-alpha"]
                 [reagent-utils "0.1.7"]
                 [secretary "1.2.3"]
                 [venantius/accountant "0.1.7"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
         '[crisptrutski.boot-cljs-test :refer [test-cljs]]
         '[adzerk.boot-test :refer :all])

(task-options! test-cljs {:js-env :phantom})

(deftask dev []
  (comp
   (serve :dir "out")
   (watch)
   (reload)
   (cljs)
   (target :dir #{"out"})))

(deftask testing []
  (merge-env! :source-paths #{"test/cljs"})
  identity)

(deftask auto-test []
  (comp (testing)
        (watch)
        (test-cljs)
        (test)))
