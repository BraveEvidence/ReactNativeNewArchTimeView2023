import type {ViewProps} from 'ViewPropTypes';
import type {HostComponent} from 'react-native';
import codegenNativeComponent from 'react-native/Libraries/Utilities/codegenNativeComponent';
import {DirectEventHandler} from 'react-native/Libraries/Types/CodegenTypes';

type Event = Readonly<{
  value: string;
}>;

export interface NativeProps extends ViewProps {
  onTimePicked?: DirectEventHandler<Event>;
  // add other props here
}

export default codegenNativeComponent<NativeProps>(
  'RTNMyTimeView',
) as HostComponent<NativeProps>;
