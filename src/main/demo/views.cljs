(ns demo.views
  (:require [demo.routes :as routes]
            [demo.subs :as subs]
            [re-frame.core :as re-frame]))

(defn page-view [{:keys [header content]}]
  [:div.page-wrapper
   [:header
    [:a.logo {:href (routes/home)} "Home"]
    [:a.logo {:href (routes/about)} "About"]]
   [:main content]])

(defn about []
  [page-view
   {:content
    [:div
     [:h1 "About"]
     "This is about it."]}])

(defn home []
  [page-view
   {:content
    [:div
     [:h1 "Example Project"]
     [:a {:href (routes/about)} "Learn More"]]}])

(defn app-view [{:keys [page-id]}]
  (case page-id
    :home
    [home]
    :about
    [about]))

(defn app-root []
  (app-view @(re-frame/subscribe [::subs/app-view])))