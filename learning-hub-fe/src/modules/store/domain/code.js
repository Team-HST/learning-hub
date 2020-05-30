import { codeService } from '@/lib/axios/service'

const state = {
  codeMap: {}
}

const getters = {}

const mutations = {
  setCodeMap: (state, codeMap) => {
    state.codeMap = codeMap
  }
}

const actions = {
  async initCodeMap({commit}) {
    let response = await codeService.getCodes();
    let codeMap = {}
    response.data.forEach(codeInfo => {
      codeMap[codeInfo['codeGroup']] = codeInfo['codes']
      commit('setCodeMap', codeMap)
    })
  }
}

export default {
  namespaced: true,
  state,
  getters,
  mutations,
  actions
}