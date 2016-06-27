var app = angular.module('trelloApp', ['ngAnimate']);
app.controller('cardCtrl', function ($scope, $http) {

    $scope.showToast = false;
    $scope.cardList ={};
    $scope.saveCard = function (id) {

        var card_json = $scope.cardList[id];
        console.log("in saveCard");
        $http.post("/trello-api/saveCard", card_json).then(function (response) {
            $scope.showToast = true;
            setTimeout(function(){$scope.showToast = false; $scope.$apply();}, 1000);
        });
    }

    $scope.addCardItem = function (id) {

        var obj = $scope.cardList[id];
        $http.get("/trello-api/getEmptyItem").then(function (response) {
            obj["checklist"].push(response.data);
            $scope.cardList[id] = obj;

        });
    };

    $scope.removeCardItem = function (cardId, entryId) {
        var obj = $scope.cardList[cardId];
        var entries = obj["checklist"];
        for (var i = 0; i < entries.length; i++) {
            var entry = entries[i];
            if (entry["id"] == entryId) {
                entries.splice(i, 1);
            }
        }
        obj["checklist"] = entries;
        $scope.cardList[cardId] = obj;

    };


    $scope.addNewCard = function () {
        $http.get("/trello-api/getEmptyCard").then(function (response) {
            var obj = response.data;
            $scope.cardList[obj["id"]] = obj;
        });
    }

    $scope.deleteCard = function (cardId) {
        console.log("in deleteCard");
        $http.delete("/trello-api/removeCard/" + cardId).success(function (data, status) {
            delete $scope.cardList[cardId];
        });
    }

    $http.get("/trello-api/listCards").then(function (response) {
        $scope.cardList = response.data;
    });

});