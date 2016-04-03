(ns boot-start-cljs.routes
  (:require [boot-start-cljs.views :as views]
            [reagent.session :as session]
            [secretary.core :as secretary :include-macros]))

(secretary/set-config! :prefix "#")

(def routes
  {"/" #(views/home-page)
   "/about" #(views/about-page)
   "/test" #(views/test-page)})

(defn add-route [path view]
  (secretary/defroute (str path) []
    (session/put! :current-page view)))

(defn init! []
  (doseq [[path view] routes]
    (add-route path view)))

;; (println "Loading routes")
;; (secretary/defroute "/" []
;;   (session/put! :current-page #'home-page))

;; (secretary/defroute "/about" []
;;   (session/put! :current-page #'about-page))
