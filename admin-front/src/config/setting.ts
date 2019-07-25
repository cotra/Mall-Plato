/**
 * @Date
 * @Remark
 */

// 加密key
export const CRYPTO_KEY = "CzbPKgELBcfAFgkY";
// 超时连接
export const TIMEOUT_SHORT = 30000;
export const TIMEOUT_LONG = 60000;
// 表格初始页码
export const TABLE_BEGIN_PAGE = 1;
// 表格初始条数
export const TABLE_BEGIN_SIZE = 10;
// 表格页码通用设置
export const TABLE_PAGINATION = {
  showTotal: (total: number, range: number[]) => {
    return `${total} 条记录中的 ${range[0]}-${range[1]} 条`;
  },
  showSizeChanger: true,
  showQuickJumper: true,
  pageSizeOptions: ["3", "10", "25", "50"]
};

export const SEARCH_FORM_LAYOUT: "horizontal" | "vertical" | "inline" =
  "inline";
// dev
export const SEARCH_FORM_PROPS = {
  layout: SEARCH_FORM_LAYOUT
};

export const SEARCH_FORM = {
  gutter: 5,
  col: { xs: 24, sm: 12, md: 12, lg: 12, xl: 6 },
  colPicker: { xs: 24, sm: 16, md: 16, lg: 16, xl: 8 }
};

export const MODAL_FORM_ITEM = {
  labelCol: {
    xl: { span: 6 }
  },
  wrapperCol: {
    xl: { span: 18 }
  }
};

export const TASK_FORM_ITEM = {
  labelCol: {
    xl: { span: 6 }
  },
  wrapperCol: {
    xl: { span: 18 }
  }
};

// table
export const FIXED_RIGHT: boolean | "right" | "left" | undefined = "right";
