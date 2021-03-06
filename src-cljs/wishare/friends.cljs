(ns wishare.friends
  (:require [quiescent :as q :include-macros true]
            [quiescent.dom :as d]))


(q/defcomponent Friend
  "Friend list item"
  [{:keys [id login real-name avatar-url to-me?]
    :or {to-me? false}}]
  (letfn [(btn [cls text]
            (d/button {:className (str "badge btn btn-default " cls)}
                      text))]
    (d/li
     {:className "list-group-item friend"}
     (d/a {:href "#"}
          (d/img {:className "img-thumbnail image64x64"
                  :src (or avatar-url "/img/noavatar.png")
                  :alt  "avatar"})
          (d/h4 {:style {:display "inline"}}
                real-name
                (d/small {} " aka \"" login "\"")))

     (if to-me?
       (btn "remove-friend" "Remove from friends")
       (btn "add-friend" "Add to friends")))))


(q/defcomponent FriendList
  [items heading mode state]
  (d/div
   {:className "panel panel-default friends"}
   heading
   (when-not (= mode :read-only)
     (apply d/ul {:className "friends list-group"}
            (map Friend items)))))
