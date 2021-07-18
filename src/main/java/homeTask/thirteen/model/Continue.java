package homeTask.thirteen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Continue {
        private Long sroffset;
        private String continue_;

        public Long getSroffset() {
                return sroffset;
        }

        public void setSroffset(Long sroffset) {
                this.sroffset = sroffset;
        }

        public String getContinue_() {
                return continue_;
        }

        public void setContinue_(String continue_) {
                this.continue_ = continue_;
        }

        @Override
        public String toString() {
                return "Continue{" +
                        "sroffset=" + sroffset +
                        ", continue_='" + continue_ + '\'' +
                        '}';
        }
}
