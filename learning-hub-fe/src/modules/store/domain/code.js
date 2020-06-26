import { codeService } from '@/lib/axios/service'
import { 
  Getters as CodeGetters, 
  Mutations as CodeMutations,
  Actions as CodeActions
} from '../types/code';

const state = {
  isCodeSetting: false,
  codeMap: {}
}

const getters = {
  [CodeGetters.GET_CODE_GROUP]: (state) => (codeGroupName, mapFunction) => {    
    let codeGroup = state.codeMap[codeGroupName];
    if (mapFunction) {
      return Object.keys(codeGroup).map((code) => mapFunction(codeGroup[code]))
    }
    return codeGroup;
  },
  [CodeGetters.GET_CODE]: (state) => (codeGroup, code) => {
    return state.codeMap[codeGroup][code];
  },
  [CodeGetters.GET_CODE_NAME]: (state, getters) => (codeGroup, code) => {
    return getters.getCode(codeGroup, code).codeName;
  }
}

const mutations = {
  [CodeMutations.SET_CODE_MAP]: (state, codeMap) => {
    state.isCodeSetting = true;
    state.codeMap = codeMap;
  }
}

const actions = {
  [CodeActions.INIT_CODE_MAP]: async ({commit}) => {
    let response = await codeService.getCodes();
    let codeMap = {}
    response.data.forEach(codeInfo => {
      codeMap[codeInfo.codeGroup] = codeInfo.codes.reduce((result, item) => {
        result[item.code] = item;
        return result;
      }, {})
      commit(CodeMutations.SET_CODE_MAP, codeMap)
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