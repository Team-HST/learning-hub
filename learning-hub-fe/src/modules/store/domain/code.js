import { codeService } from '@/lib/axios/service'

const state = {
  isCodeSetting: false,
  codeMap: {}
}

const getters = {
  getCodeGroup: (state) => (codeGroupName, mapFunction) => {    
    let codeGroup = state.codeMap[codeGroupName];
    if (mapFunction) {
      return Object.keys(codeGroup).map((code) => mapFunction(codeGroup[code]))
    }
    return codeGroup;
  },
  getCode: (state) => (codeGroup, code) => {
    return state.codeMap[codeGroup][code];
  },
  getCodeName: (state, getters) => (codeGroup, code) => {
    return getters.getCode(codeGroup, code).codeName;
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
      codeMap[codeInfo.codeGroup] = codeInfo.codes.reduce((result, item) => {
        result[item.code] = item;
        return result;
      }, {})
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