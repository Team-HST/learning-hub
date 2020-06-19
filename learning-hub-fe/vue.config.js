module.exports = {
  publicPath: '',
  devServer: {
    host: '0.0.0.0',
    port: 80,
    disableHostCheck: true,
		proxy: {
			'/api': {
        target: 'http://localhost:8000',
        changeOrigin: true,
        pathRewrite: {'^/api': ''}
			}
		}
	},
  transpileDependencies: [
    'vuetify'
  ]
}