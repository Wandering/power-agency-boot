;"use strict";
;(function($){


	/**
	 * 表单的常规校验
	 * @param  {[type]} norm    [字符串 || 正则表达式]
	 * @param  {[type]} err     [错误提示的元素的选择器]
	 * @param  {[type]} errText [错误提示语]
	 * @return {[type]}         [Boolean 校验是否通过]
	 */
	$.fn.validator = function( norm, err, errText ){
		var _ts = $(this);

		//选框校验
		if( _ts.prop('type')=='radio' || _ts.prop('type')=='checkbox' ) {
			if( _ts.selector.length>0 ) {
				return $.inRange( $(_ts.selector+':checked').length, norm ) ? errHide( err ) : errShow( _ts, err, errText );
			} else {
				console.error( '\t$.fn.validator 使用错误：\n\t被选取元素为0；\n\t$(this).validator() 的写法将找不到selector；' );
				return false;
			}
		}

		//非选框，并且 norm 为字符串（用来校验两值一致，如确认密码等）
		if( typeof norm=='string' ) {
			return norm==_ts.val() ? errHide( err ) : errShow( _ts, err, errText );
		}

		//常规的正则校验（如：邮箱、手机号、用户名等）
		return norm.test( _ts.val() ) ? errHide( err ) : errShow( _ts, err, errText );

		function errShow( ts, err, errText ) {
			ts.focus();
			$(err).show(0).text( errText );
			return false;
		}

		function errHide( err ) {
			setTimeout(function(){
				$(err).hide(0).empty();
			},200);
			return true;
		}

	};


	/**
	 * 判断数字num是否在区间strs内
	 * @param  {[type]} num  [Number 一个数字，表示实际数量]
	 * @param  {[type]} range [Number or String 表示区间的数字类型或字符串类型]
	 * @return {[type]}      [Boolean 符合条件返回true]
	 * 区间是数学概念，有以下几种：
	 * 	m
	 *	(m,)
	 *	(,n)
	 *	(m,n)
	 *	[m,)
	 *	(,n]
	 *	[m,n]
	 *	(m,n]
	 *	[m,n)
	 */
	$.inRange = function( num, range ){
		//m
		if( !/^\(|\)|\[|\]$/.test( range ) ) {
			return num==parseFloat( range );
		//(m,)
		} else if( /^\(\d*\.?\d*,\)$/.test( range ) ) {
			return num>parseFloat(range.replace(/\(|,|\)/g,''));
		//(,n)
		} else if( /^\(,\d*\.?\d*\)$/.test( range ) ) {
			return num<parseFloat(range.replace(/\(|,|\)/g,''));
		//(m,n)
		} else if( /^\(\d*\.?\d*,\d*\.?\d*\)$/.test( range ) ) {
			var arr = range.replace(/\(|\)/g,'').split(',');
			return num>parseFloat(arr[0]) && num<parseFloat(arr[1]);
		//[m,)
		} else if( /^\[\d*\.?\d*,\)$/.test( range ) ) {
			return num>=parseFloat(range.replace(/\[|,|\)/g,''));
		//(,n]
		} else if( /^\(,\d*\.?\d*\]$/.test( range ) ) {
			return num<=parseFloat(range.replace(/\(|,|\]/g,''));
		//[m,n]
		} else if( /^\[\d*\.?\d*,\d*\.?\d*\]$/.test( range ) ) {
			var arr = range.replace(/\[|\]/g,'').split(',');
			return num>=parseFloat(arr[0]) && num<=parseFloat(arr[1]);
		//(m,n]
		} else if( /^\(\d*\.?\d*,\d*\.?\d*\]$/.test( range ) ) {
			var arr = range.replace(/\(|\]/g,'').split(',');
			return num>parseFloat(arr[0]) && num<=parseFloat(arr[1]);
		//[m,n)
		} else if( /^\[\d*\.?\d*,\d*\.?\d*\)$/.test( range ) ) {
			var arr = range.replace(/\[|\)/g,'').split(',');
			return num>=parseFloat(arr[0]) && num<parseFloat(arr[1]);
		} else {
			return false;
		}
	};

})(jQuery);