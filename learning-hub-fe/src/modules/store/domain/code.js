import { codeService } from '@/lib/axios/service'

const state = {
  isCodeSetting: false,
  codeMap: {}
}

const getters = {
  getCodeMap: (state) => {
    return state.codeMap
  }
}

const mutations = {
  setCodeMap: (state, codeMap) => {
    state.isCodeSetting = true;
    state.codeMap = codeMap;
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