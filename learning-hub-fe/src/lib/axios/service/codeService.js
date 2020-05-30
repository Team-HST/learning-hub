import http from '../http'

/**
 * Code API 서비스
 * 
 * @author hyungyu.lee
 */
export default {
  /**
   * 모든 코드그룹 목록 조회
   * 
   * @returns 코드그룹 목록
   */
  getCodes() {
    return http.get('/api/codes');
  }
}