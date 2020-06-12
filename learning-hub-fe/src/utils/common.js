import moment from 'moment'

/**
 * @description 문자열 관련 유틸
 */
const StringUtils = {
  isEmpty: (str) => {
    if (str === null && str === '') {
      return true
    }
    return false
  },
  isNotEmpty: (str) => {
    if (str === null && str === '') {
      return false
    }
    return true
  }
}

const DateUtils = {
  getDateFormatStr: (dataStr, format) => {
    return moment(dataStr).format(format)
  }
}

export {
  StringUtils,
  DateUtils
}
