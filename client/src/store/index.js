import Vue from "vue";
import Vuex from "vuex";

import actions from "./actions";

import auctions from "./modules/auctions";
import dogs from "./modules/dogs";
import users from "./modules/users";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    userId: null,
    username: null,
    apiAvailable: true,
    apiErrors: []
  },
  mutations: {
    setUserId(state, userId) {
      state.userId = userId;
    },
    setUsername(state, username) {
      state.username = username;
    },
    apiAvailable(state) {
      state.apiAvailable = true;
    },
    apiUnavailable(state) {
      state.apiAvailable = false;
    },
    addAPIError(state, error) {
      state.apiErrors.push(error);
    },
    removeAPIError(state, error) {
      let index = state.apiErrors.indexOf(error);
      if (index >= 0) Vue.delete(state.apiErrors, index);
    },
    clearAPIErrors(state) {
      state.apiErrors = [];
    }
  },
  actions,
  modules: {
    auctions,
    dogs,
    users
  }
});
