(ns boot-start-cljs.views)

(defn home-page []
  [:div.demo [:h2 "Test page"]
   [:div [:a {:href "/about"} "go to about page 2"]]
   [:div [:a {:href "/test"} "go to test page"]]])

(defn about-page []
  [:div [:h2 "About page 2"]
   [:div [:a {:href "/"} "go to the home page"]]])

(defn test-page []
  [:div [:h2 "Test page 2"]
   [:div [:a {:href "/"} "go to the home page"]]])
