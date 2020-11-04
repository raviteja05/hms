const path=require('path')
const webpack = require('webpack')
const { config } = require('process')

module.exports={
    entry:{
        home:'./src/pages/home/index.js',
        login:'./src/pages/auth/login.js',
        signup:'./src/pages/auth/register.js',
        "create-user":'./src/pages/auth/register.js',
        dashboard:'./src/pages/dashboard/index.js',
        "contact-us":'./src/pages/contact/contact.js',
        404:'./src/pages/error/index.js',
        "view-appointments":'./src/pages/appointments/bookappointments.js',
        "view-doctors":'./src/pages/view-all-doctors/index.js',
        "booking-success":'./src/pages/bookingsuccess/index.js',
        "my-appointments":'./src/pages/appointments/viewmyappointments.js',
        "view-appointment":'./src/pages/appointments/viewpatientappointment.js'
        
    },
    output:{
        path:path.join(__dirname,'public','js','dist'),
        filename:"[name].bundle.js"
    },
    module: {
      rules: [
          {
              test: /\.(js|jsx)$/,
              exclude: /node_modules/,
              use: [{
                  loader: 'babel-loader',
                  options: { presets: ['@babel/preset-react', '@babel/preset-env'] }
              }]
          },
          {
            test:/\.css$/,
            exclude: /node_modules/,
            use:['style-loader','css-loader']

          }
        ]
          
      },

      devServer: {
        contentBase: path.join(__dirname, 'public'),
        compress: true,
        port: 9000
      }
}