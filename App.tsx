/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React from 'react';
import type {PropsWithChildren} from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  useWindowDimensions,
  View,
} from 'react-native';

import {
  Colors,
  DebugInstructions,
  Header,
  LearnMoreLinks,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import RTNMyTimeView from 'rtn-my-time-view/js/RTNMyTimeViewNativeComponent';

function App(): JSX.Element {
  const isDarkMode = useColorScheme() === 'dark';

  const backgroundStyle = {
    backgroundColor: isDarkMode ? Colors.darker : Colors.lighter,
  };

  const {width} = useWindowDimensions();

  return (
    <SafeAreaView style={backgroundStyle}>
      <StatusBar
        barStyle={isDarkMode ? 'light-content' : 'dark-content'}
        backgroundColor={backgroundStyle.backgroundColor}
      />
      <RTNMyTimeView
        style={{
          height: 200,
          width,
          margin: 20,
        }}
        onTimePicked={(value: any) => {
          console.log(value.nativeEvent.value);
        }}
      />
    </SafeAreaView>
  );
}

export default App;

//yarn add ./RTNMyTimeView
//node rnapp/node_modules/react-native/scripts/generate-codegen-artifacts.js \
// --path rnapp/ \
// --outputPath rnapp/RTNMyTimeView/generated/
