(ns listbox.core
  (:require
   [listbox.routes :as routes]
   [listbox.views :as views]
   [reagent.core :as r]
   [reagent.session :as session]
   [secretary.core :as secretary :include-macros]
   [accountant.core :as accountant]))


(defn current-page []
  [:div [(session/get :current-page)]])

;; -------------------------
;; Routes

;; (secretary/defroute "/" []
;;   (session/put! :current-page #(views/home-page)))

;; (secretary/defroute "/about" []
;;   (session/put! :current-page #(views/home-page)))

;; -------------------------
;; Initialize app

(enable-console-print!)
(println "Enabled console print")
(routes/init!)

(defn mount-root []
  (r/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!
   {:nav-handler
    (fn [path]
      (secretary/dispatch! path))
    :path-exists?
    (fn [path]
      (secretary/locate-route path))})
  (accountant/dispatch-current!)
  (mount-root))
